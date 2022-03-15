package com.dsrise.daggersampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dsrise.daggersampleapp.di.app.FakerApplication
import com.dsrise.daggersampleapp.viewmodel.MyViewModelFactory
import com.dsrise.daggersampleapp.viewmodel.ProductViewModel
import com.dsrise.daggersampleapp.viewmodel.ProductViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var productViewModel: ProductViewModel

    private val productTv: TextView
        get() = findViewById(R.id.products)

    //    @Inject
//    lateinit var productViewModelFactory: ProductViewModelFactory
    @Inject
    lateinit var myViewModelFactory: MyViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as FakerApplication).appComponent.inject(this)
        productViewModel =
            ViewModelProvider(this, myViewModelFactory).get(ProductViewModel::class.java)
        productViewModel.mProduct.observe(this, Observer {
            productTv.text = it.joinToString { x -> x.title + "\n\n" }
        })
    }
}