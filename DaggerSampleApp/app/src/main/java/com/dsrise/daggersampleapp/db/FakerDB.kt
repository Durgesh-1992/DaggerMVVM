package com.dsrise.daggersampleapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dsrise.daggersampleapp.model.Products

@Database(entities = [Products::class], version = 1)
abstract class FakerDB :RoomDatabase() {
    abstract fun getFakerDAO(): FakerDAO
}