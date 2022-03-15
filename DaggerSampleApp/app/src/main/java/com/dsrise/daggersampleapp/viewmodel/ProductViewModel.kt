package com.dsrise.daggersampleapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dsrise.daggersampleapp.model.Products
import com.dsrise.daggersampleapp.repository.ProductRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductViewModel @Inject constructor(private val repository: ProductRepository) : ViewModel() {
    val mProduct: LiveData<List<Products>>
        get() = repository.product

    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }
}