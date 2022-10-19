package com.example.shopeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.shopeasy.userpage.UserLoginResp;

public class UserDetails extends AppCompatActivity {

    TextView nameU,emailU,numberU,rfidU;

    LoginRes loginRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        nameU = findViewById(R.id.nameOfUser);
        emailU = findViewById(R.id.emailOfUser);
        numberU = findViewById(R.id.numberOfUser);
        rfidU = findViewById(R.id.rfidOfUser);

        Intent intent = getIntent();
        if(intent.getExtras()!=null) {
            loginRes = (LoginRes) intent.getSerializableExtra("userdetails");
        }

        String user_name = loginRes.getName();
        String user_email = loginRes.getEmail();
        String user_number = loginRes.getNumber();
        String user_rfid = loginRes.getRFID();

        nameU.setText("Name: "+user_name);
        emailU.setText("Email: "+user_email);
        numberU.setText("Number: "+user_number);
        rfidU.setText("RFID: "+user_rfid);

    }
}