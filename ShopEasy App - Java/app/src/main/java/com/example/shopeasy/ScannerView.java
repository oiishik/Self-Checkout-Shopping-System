package com.example.shopeasy;

import android.content.Intent;
import android.os.Bundle;
import android.Manifest;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.zxing.Result;
import com.journeyapps.barcodescanner.CaptureActivity;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ScannerView extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    ZXingScannerView scannerView;
    String rfidNo;
    String barcode;
    RecyclerView recyclerView;
    UserPage userPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         userPage = new UserPage();
        scannerView=new ZXingScannerView(this);
        setContentView(scannerView);
        Intent intent =getIntent();
        if(intent.getExtras()!=null){
            rfidNo= intent.getStringExtra("rfid");
        }

        Dexter.withContext(getApplicationContext())
                .withPermission(Manifest.permission.CAMERA)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        scannerView.startCamera();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                }).check();
    }

    @Override
    public void handleResult(Result rawResult) {
        barcode = rawResult.getText();
        if(addItem(barcode,rfidNo)) {
            userPage.getAllProducts(rfidNo);
        }
        onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();
        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }

    public boolean addItem(String barcode,String rfidNo){
        final boolean[] res = {false};
        Call<String> resp = APIClientString.getUserPageService().addProduct(barcode,rfidNo);
        resp.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    Toast.makeText(ScannerView.this, response.body().toString(), Toast.LENGTH_SHORT).show();
                    res[0] =true;
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("failedadd", ""+t);
            }
        });
        return res[0];
    }
}
