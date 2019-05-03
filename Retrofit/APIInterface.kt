package com.example.kotlindemonew.Activity.Retrofit

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface APIInterface {
    @FormUrlEncoded
    @POST("login.php")
    fun login(@Field("adminCode") name: String, @Field("adminPassword") password: String):
    Call<LoginResponse>


    @Multipart
    @POST("login.php")
    fun loginlist(@Field("adminCode") name: String,
                  @Field("adminPassword") password: String):
            Call<LoginResponse>


   // @POST("brand_list.php")
    @POST("pro_list.php")
    fun list(): Call<ProductResponse>



}

