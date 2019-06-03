package com.example.shoplist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.shoplist.database.DataBaseApp
import com.example.shoplist.database.entity.Item
import com.example.shoplist.repository.RepositoryItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelItem(application: Application) : AndroidViewModel(application) {

    private val repositoryItem: RepositoryItem

    val getAllItems: LiveData<List<Item>>

    init {

        val daoItem = DataBaseApp.getDatabase(application, viewModelScope).daoItem()

        repositoryItem = RepositoryItem(daoItem)

        getAllItems = repositoryItem.getAllItems

    }


    fun insert(item: Item) = viewModelScope.launch(Dispatchers.IO) {
        repositoryItem.insert(item)
    }
}