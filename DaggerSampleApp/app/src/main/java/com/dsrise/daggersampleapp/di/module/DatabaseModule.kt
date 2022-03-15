package com.dsrise.daggersampleapp.di.module

import android.content.Context
import androidx.room.Room
import com.dsrise.daggersampleapp.db.FakerDB
import com.dsrise.daggersampleapp.utils.Constant
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun getRoomDataBaseInstance(context: Context): FakerDB {
        return Room.databaseBuilder(context, FakerDB::class.java, Constant.DB_NAME).build()
    }
}