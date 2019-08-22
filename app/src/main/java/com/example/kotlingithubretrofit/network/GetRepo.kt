package com.example.kotlingithubretrofit.network

import com.example.kotlingithubretrofit.models.GithubRepo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GetRepo {
    @GET("users/{user}/repos")
    fun getRepos(@Path("user") user: String): Call<List<GithubRepo>>
}