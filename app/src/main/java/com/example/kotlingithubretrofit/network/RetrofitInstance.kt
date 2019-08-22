package com.example.kotlingithubretrofit.network

import com.example.kotlingithubretrofit.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    val retrofitInstance: Retrofit
    get()

    {

        val loggingInterceptor = HttpLoggingInterceptor()
        val okHttpClient = OkHttpClient.Builder()
            .build()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}