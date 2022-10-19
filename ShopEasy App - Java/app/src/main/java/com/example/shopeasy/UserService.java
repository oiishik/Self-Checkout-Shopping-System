package com.example.shopeasy;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("user/userExists")
   Call<LoginRes> userLogin(@Body LoginReq loginReq);
}
