package com.example.job_01

import retrofit2.http.GET

interface apiService {
    @GET("products")
    suspend fun  getProducts(): List<Products>

}