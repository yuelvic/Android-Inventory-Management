package io.chaman.im.ui.item

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import io.chaman.im.data.entities.Request
import io.chaman.im.data.entities.Supply
import io.chaman.im.data.repository.SupplyRepository
import io.chaman.im.databinding.ReceiveItemFragmentBinding

class SupplyViewModel(application: Application) : AndroidViewModel(application) {

    var mSupplyRepository: SupplyRepository = SupplyRepository(application)
    var mSupplies: LiveData<List<Supply>>
    var mSupplyCount: LiveData<Int>

    init {
        this.mSupplies = this.mSupplyRepository.getSupplies()
        this.mSupplyCount = this.mSupplyRepository.count()
    }

    fun getSupplies() = this.mSupplies

    fun count() = this.mSupplyCount

    fun addSupply(binding: ReceiveItemFragmentBinding, request: Request) {
        val supply = Supply()
        supply.name = request.name
        supply.employeeId = request.employeeId
        supply.lastRequested = request.lastRequested
        supply.quantity = request.quantity
        supply.unit = request.unit
        supply.safetyStock = request.safetyStock
        supply.price = request.price
        supply.imageUrl = request.imageUrl

        this.mSupplyRepository.add(supply)
    }

    fun deleteSupply() {

    }

}
