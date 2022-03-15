package com.dsrise.daggersampleapp.di.component

import android.content.Context
import androidx.lifecycle.ViewModel
import com.dsrise.daggersampleapp.MainActivity
import com.dsrise.daggersampleapp.di.module.DatabaseModule
import com.dsrise.daggersampleapp.di.module.NetworkModule
import com.dsrise.daggersampleapp.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class, ViewModelModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun getMap(): Map<Class<*>, ViewModel>

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}