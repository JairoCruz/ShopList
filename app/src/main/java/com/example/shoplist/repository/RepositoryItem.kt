package com.example.shoplist.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.shoplist.database.dao.DaoItem
import com.example.shoplist.database.entity.Item

class RepositoryItem(private val daoItem: DaoItem) {

    val getAllItems: LiveData<List<Item>> = daoItem.getAllItems()

    @WorkerThread
    suspend fun insert(item: Item){
        daoItem.insert(item)
    }

    @WorkerThread
    suspend fun delete(item: Item) {
        daoItem.delete(item)
    }

    @WorkerThread
    suspend fun update(item: Item){
        daoItem.update(item)
    }

}