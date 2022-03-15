package com.dsrise.daggersampleapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dsrise.daggersampleapp.db.FakerDB
import com.dsrise.daggersampleapp.di.apiinterface.FakerAPI
import com.dsrise.daggersampleapp.model.Products
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val fakerAPI: FakerAPI, private val fakerDB: FakerDB
) {
    private val mProducts = MutableLiveData<List<Products>>()
    val product: LiveData<List<Products>>
        get() = mProducts

    suspend fun getProducts() {
        val result = fakerAPI.getProducts()
        if (result.isSuccessful && result.body() != null) {
            fakerDB.getFakerDAO().addProducts(result.body()!!)
            mProducts.postValue(result.body())
        }
    }
}