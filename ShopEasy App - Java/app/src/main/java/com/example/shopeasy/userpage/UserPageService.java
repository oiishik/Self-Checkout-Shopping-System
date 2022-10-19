package com.example.shopeasy.userpage;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserPageService {
    @POST("cart/getItems")
    Call<List<UserLoginResp>>getCartItems(@Query("userid") String RFID);

    @POST("cart/deleteItem")
    Call<String> deleteProduct(@Query("barcode") String barcode, @Query("userid") String userid);

    @POST("cart/getTotal")
    Call<getBill> getBill(@Query("userid") String userid);

    @POST("cart/emptyCart")
    Call<String> checkout(@Query("userid") String userid);

    @POST("cart/add")
    Call<String> addProduct(@Query("barcode") String barcode, @Query("userid") String userid);
}
