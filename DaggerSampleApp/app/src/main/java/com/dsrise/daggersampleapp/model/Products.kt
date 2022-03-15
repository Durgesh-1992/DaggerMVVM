package com.dsrise.daggersampleapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Product")
data class Products(
    val category: String,
    val description: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val image: String,
    val price: Double,
//    val rating: Rating,
    val title: String
)