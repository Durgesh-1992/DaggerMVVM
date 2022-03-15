package com.dsrise.daggersampleapp.di.apiinterface

import com.dsrise.daggersampleapp.model.Products
import retrofit2.Response
import retrofit2.http.GET

interface FakerAPI {

    @GET("products")
    suspend fun getProducts(): Response<List<Products>>
}