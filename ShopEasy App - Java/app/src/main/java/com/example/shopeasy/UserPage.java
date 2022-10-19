package com.example.shopeasy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopeasy.userpage.ProductAdaptar;
import com.example.shopeasy.userpage.UserLoginResp;
import com.example.shopeasy.userpage.getBill;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserPage extends AppCompatActivity implements ProductAdaptar.clickedItem {
        Toolbar toolbar;
        RecyclerView recyclerView;
        String rfidNo;
        LoginRes loginRes;
        Button scanItem;
        Button payBill;
        TextView total;
        Button userDetails;
        ProductAdaptar productAdaptar;
        Call<List<UserLoginResp>> productList;
        List<UserLoginResp> productListsItems = new ArrayList<>();

    @Override
    protected void onStart() {
        super.onStart();

        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            loginRes = (LoginRes) intent.getSerializableExtra("userdetails");
        }
        rfidNo = loginRes.getRFID();
        getAllProducts(rfidNo);
    }

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_user_page);
            toolbar=findViewById(R.id.toolbar);
            recyclerView=findViewById(R.id.recyclerview);
            scanItem = findViewById(R.id.scanItem);
            payBill = findViewById(R.id.payBill);
            total = findViewById(R.id.total);
            userDetails = findViewById(R.id.userDetails);

            scanItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    startActivity(new Intent(getApplicationContext(),ScannerView.class).putExtra("rfid",rfidNo));
                }
            });

            userDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(UserPage.this,UserDetails.class).putExtra("userdetails",loginRes));
                }
            });

            payBill.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkout();
                }
            });

            LinearLayoutManager manager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(manager);
            recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
            productAdaptar = new ProductAdaptar(this::clickedProduct, this);

            Intent intent =getIntent();
            if(intent.getExtras()!=null){
                rfidNo= intent.getStringExtra("rfid");
            }
            getAllProducts(rfidNo);
            }
            public void getAllProducts(String rfidno){
                LinearLayoutManager manager = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(manager);
                productAdaptar = new ProductAdaptar(this::clickedProduct,this);
                productList= ApiClient.getUserPageService().getCartItems(rfidno);
                productList.enqueue(new Callback<List<UserLoginResp>>() {
                    @Override
                    public void onResponse(Call<List<UserLoginResp>> call, Response<List<UserLoginResp>> response) {
                        if (response.isSuccessful()) {
                            productListsItems = response.body();
                            productAdaptar.setData(productListsItems);
                            RecyclerView recyclerView = findViewById(R.id.recyclerview);
                            recyclerView.setAdapter(productAdaptar);
                            getTotal();
                        }
                    }
                    @Override
                    public void onFailure(Call<List<UserLoginResp>> call, Throwable t) {
                        Log.e("listfailed",t.getLocalizedMessage());
                    }
                });
        }

        public void getTotal(){
                Call<getBill> bill = ApiClient.getUserPageService().getBill(rfidNo);
                bill.enqueue(new Callback<getBill>() {
                    @Override
                    public void onResponse(Call<getBill> call, Response<getBill> response) {
                        if(response.isSuccessful()){
                            getBill getBill = response.body();
                            String bill = String.valueOf(getBill.getBill());
                            total.setText("Total: Rs "+bill);
                        }
                    }

                    @Override
                    public void onFailure(Call<getBill> call, Throwable t) {
                        Log.e("bill error",""+t);
                    }
                });
    }

    public void checkout(){
        Call<String> payment= APIClientString.getUserPageService().checkout(rfidNo);
        payment.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    getAllProducts(rfidNo);
                    Toast.makeText(UserPage.this, "Payment Successful", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                    Log.e("paymentfail",""+t);
            }
        });
    }


    @Override
    public void clickedProduct(UserLoginResp userLoginResp) {
            Log.e("deleted prodcut", userLoginResp.toString());
            startActivity(new Intent(this,ProductDetails.class)
                    .putExtra("details",userLoginResp));
    }

    }







