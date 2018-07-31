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

    fun getSupply(supplyId: Int): LiveData<Supply> {
        return this.mSupplyRepository.getSupply(supplyId)
    }

    fun count() = this.mSupplyCount

    fun addSupply(binding: ReceiveItemFragmentBinding, request: Request) {
        if (hasExistingSupply(request.supplyId)) {
            val supply = getSupply(request.supplyId).value
            supply!!.quantity += request.quantity
            update(supply!!)
        } else {
            val supply = Supply()
            supply.name = request.name
            supply.employeeId = request.employeeId
            supply.lastRequested = request.lastRequested
            supply.quantity = request.requested
            supply.unit = request.unit
            supply.safetyStock = request.safetyStock
            supply.price = request.price
            supply.imageUrl = request.imageUrl
            supply.barcode = binding.etReceiveBarcode.text.toString()

            this.mSupplyRepository.add(supply)
        }
    }

    fun update(supply: Supply) {
        this.mSupplyRepository.update(supply)
    }

    fun delete(supply: Supply) {
        this.mSupplyRepository.delete(supply)
    }

    fun hasExistingSupply(supplyId: Int): Boolean {
        val supply = getSupply(supplyId)
        return supply.value != null
    }

}
