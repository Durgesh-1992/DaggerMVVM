package com.dsrise.daggersampleapp.di.module

import androidx.lifecycle.ViewModel
import com.dsrise.daggersampleapp.viewmodel.ProductViewModel
import com.dsrise.daggersampleapp.viewmodel.ProductViewModel2
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    /**
     * Remark :
     * @Binds is used to bind requested view model with ViewModel type, so
     * if we have three or more view model then we mapping/binding it to ViewModel Type
     * so here multibinding is happening i.e since we have view model associated with each class
     * so there creation needs ViewModelFactory but at the end they are of type ViewModel
     * @ClassKey/@StringKey : It is the key which is used to store object of respective
     * view model into map. This key type may be string or class. But normally incase of
     * viewmodel we use class key
     * @IntoMap : it tell dagger2 to create the map with key as classkey annotated and value
     * as requested view model passed as argument in the function
     */
    @Binds
    @ClassKey(ProductViewModel::class)
    @IntoMap
    abstract fun bindProductViewModel(productViewModel: ProductViewModel): ViewModel
    @Binds
    @ClassKey(ProductViewModel2::class)
    @IntoMap
    abstract fun bindProductViewModel2(productViewModel: ProductViewModel2): ViewModel
}