package com.dsrise.daggersampleapp.di.app

import android.app.Application
import com.dsrise.daggersampleapp.di.component.AppComponent
import com.dsrise.daggersampleapp.di.component.DaggerAppComponent

class FakerApplication : Application() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
//        appComponent = DaggerAppComponent.builder().build()
        appComponent = DaggerAppComponent.factory().create(this)
    }
}