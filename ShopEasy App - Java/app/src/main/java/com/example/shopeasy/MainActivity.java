package com.example.shopeasy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextInputEditText mobileNo;
    Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobileNo = findViewById(R.id.mobile);
        loginBtn = findViewById(R.id.loginbtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(Objects.requireNonNull(mobileNo.getText()).toString())) {
                    Toast.makeText(MainActivity.this, "Please Enter Mobile Number", Toast.LENGTH_LONG).show();
                }else{
                        login();
                }
            }
        });
    }

    public void login(){
        LoginReq loginReq = new LoginReq();
        loginReq.setNumber(Objects.requireNonNull(mobileNo.getText()).toString());
        Call<LoginRes> loginResCall = ApiClient.getUserService().userLogin(loginReq);
        loginResCall.enqueue(new Callback<LoginRes>() {
            @Override
            public void onResponse(@NonNull Call<LoginRes> call, @NonNull Response<LoginRes> response) {
                if(response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                    LoginRes loginRes= response.body();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            assert loginRes != null;
                            startActivity(new Intent(MainActivity.this,UserPage.class).
                                    putExtra("userdetails",loginRes));
                        }
                    }, 700);
                }else{
                    Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<LoginRes> call, @NonNull Throwable t) {
                Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_LONG).show();
                Log.println(Log.DEBUG,"login error", "Throwable"+t.getLocalizedMessage());
            }
        });
    }
}
