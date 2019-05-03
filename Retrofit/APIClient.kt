package com.example.kotlindemonew.Activity.Retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class APIClient {
   companion object{
       @JvmStatic
       fun getClient(): Retrofit {
          var retrofit: Retrofit? = null

           val interceptor = HttpLoggingInterceptor()
           interceptor.level = HttpLoggingInterceptor.Level.BODY

           val okHttpClient = OkHttpClient().newBuilder()
               .connectTimeout(6000, TimeUnit.SECONDS)
               .readTimeout(6000, TimeUnit.SECONDS)
               .writeTimeout(6000, TimeUnit.SECONDS)
               .addInterceptor(interceptor)
               .build()
           //        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
           retrofit = Retrofit.Builder()
               .baseUrl(Utills.BaseUrl)
               .addConverterFactory(GsonConverterFactory.create())
               .client(okHttpClient)
               .build()
           return retrofit
       }
   }

}