package io.chaman.im.ui.item

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.chaman.im.data.entities.Item
import io.chaman.im.data.MockData

class ItemViewModel : ViewModel() {

    private val itemList = MutableLiveData<List<Item>>()

    init {
        itemList.postValue(MockData.provideItems())
    }

    fun getItems() = itemList

}
