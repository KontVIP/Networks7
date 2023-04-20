package com.example.networks7

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @Headers("Content-Type: application/json")
    @GET("/posts/{id}")
    suspend fun getData(@Path("id") id: Int): Response<Data.Base>
}