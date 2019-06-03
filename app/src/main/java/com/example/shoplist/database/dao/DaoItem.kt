package com.example.shoplist.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shoplist.database.entity.Item

@Dao
interface DaoItem {

    @Query("SELECT * FROM items")
    fun getAllItems(): LiveData<List<Item>>

    @Insert
    fun insert(item: Item)

    @Delete
    fun delete(item: Item)

    @Update
    fun update(item: Item)
}