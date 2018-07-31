package io.chaman.im.ui.item

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import io.chaman.im.data.entities.Request
import io.chaman.im.data.repository.RequestRepository
import io.chaman.im.databinding.AddItemFragmentBinding
import io.chaman.im.utils.ContentUtils

class RequestViewModel(application: Application) : AndroidViewModel(application) {

    var mRequestRepository: RequestRepository = RequestRepository(application)
    var mRequests: LiveData<List<Request>>
    var mRequestCount: LiveData<Int>

    init {
        this.mRequests = this.mRequestRepository.getRequests()
        this.mRequestCount = this.mRequestRepository.count()
    }

    fun getRequests() = this.mRequests

    fun count() = this.mRequestCount

    fun addRequest(binding: AddItemFragmentBinding) {
        val request = Request()
        request.name = ContentUtils.getString(binding.etItemName, "Supply")
        request.requested = ContentUtils.getInt(binding.etItemQuantity, 0)
        request.safetyStock = ContentUtils.getInt(binding.etItemSafety, 0)
        request.price = ContentUtils.getInt(binding.etItemQuantity, 0) *
                ContentUtils.getInt(binding.etItemPrice, 0) + .00
        request.imageUrl = ContentUtils.getString(binding.ivItemImage, "")
        this.mRequestRepository.add(request)
    }

    fun delete(request: Request) {
        this.mRequestRepository.delete(request)
    }

}
