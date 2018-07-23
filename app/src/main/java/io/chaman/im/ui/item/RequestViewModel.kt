package io.chaman.im.ui.item

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import io.chaman.im.data.entities.Request
import io.chaman.im.data.repository.RequestRepository
import io.chaman.im.databinding.AddItemFragmentBinding

class RequestViewModel(application: Application) : AndroidViewModel(application) {

    var mRequestRepository: RequestRepository = RequestRepository(application)
    var mRequests: LiveData<List<Request>>

    init {
        this.mRequests = this.mRequestRepository.getRequests()
    }

    fun getRequests() = this.mRequests

    fun addRequest(binding: AddItemFragmentBinding) {
        val request = Request()
        request.name = binding.etItemName.text.toString()
        request.requested = Integer.parseInt(binding.etItemQuantity.text.toString())
        request.safetyStock = Integer.parseInt(binding.etItemSafety.text.toString())
        request.price = Integer.parseInt(binding.etItemQuantity.text.toString()) *
                Integer.parseInt(binding.etItemPrice.text.toString()) + .0
        request.imageUrl = binding.ivItemImage.contentDescription.toString()
        this.mRequestRepository.add(request)
    }

}
