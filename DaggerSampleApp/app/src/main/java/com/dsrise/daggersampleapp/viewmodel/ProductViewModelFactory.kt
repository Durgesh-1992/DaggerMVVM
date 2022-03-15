package com.dsrise.daggersampleapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dsrise.daggersampleapp.repository.ProductRepository
import javax.inject.Inject

//class ProductViewModelFactory @Inject constructor(private val repository: ProductRepository) :
class ProductViewModelFactory @Inject constructor(private val productViewModel: ProductViewModel) :

    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return ProductViewModel(repository) as T
        return productViewModel as T
    }
}