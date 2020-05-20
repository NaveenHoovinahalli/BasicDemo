package com.example.mydemosample


import retrofit2.http.GET

interface Api {

    @GET("marvel")
    fun getHeros(): retrofit2.Call<List<Hero>>
}