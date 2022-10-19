package com.example.shopeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.shopeasy.userpage.UserLoginResp;

public class ProductDetails extends AppCompatActivity {

    TextView nameP,pricesP,barcodeP,detailsP;

    UserLoginResp userLoginResp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        nameP = findViewById(R.id.nameProduct);
        pricesP = findViewById(R.id.priceProduct);
        barcodeP = findViewById(R.id.barcodeProduct);
        detailsP = findViewById(R.id.detailsProduct);

        Intent intent = getIntent();
        if(intent.getExtras()!=null) {
            userLoginResp = (UserLoginResp) intent.getSerializableExtra("details");
        }

            String product_name = userLoginResp.getProductName();
            String product_price = userLoginResp.getProductPrice();
            String product_barcode = userLoginResp.getProductID();
            String details = userLoginResp.getQuantity();

            nameP.setText("Name: "+product_name);
            pricesP.setText("Price: "+product_price);
            barcodeP.setText("Barcode: "+product_barcode);
            detailsP.setText("Quantity: "+details);

    }
}