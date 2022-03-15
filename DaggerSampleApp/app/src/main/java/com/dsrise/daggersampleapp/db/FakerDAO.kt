package com.dsrise.daggersampleapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dsrise.daggersampleapp.model.Products

@Dao
interface FakerDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProducts(products: List<Products>)

    @Query("SELECT * FROM Product")
    suspend fun getProducts(): List<Products>
}