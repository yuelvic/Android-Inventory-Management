package io.chaman.im.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import io.chaman.im.data.dao.SupplyDao
import io.chaman.im.data.database.SupplyDatabase
import io.chaman.im.data.entities.Supply
import org.jetbrains.anko.doAsync

class SupplyRepository(application: Application) {

    var mSupplyDao: SupplyDao
    var mSupplies: LiveData<List<Supply>>
    var mSupplyCount: LiveData<Int>

    init {
        val db = SupplyDatabase.getDatabase(application)
        this.mSupplyDao = db!!.supplyDao()
        this.mSupplies = this.mSupplyDao.getSupplies()
        this.mSupplyCount = this.mSupplyDao.count()
    }

    fun getSupplies() = this.mSupplies

    fun getSupply(supplyId: Int): LiveData<Supply> {
        return this.mSupplyDao.getSupply(supplyId)
    }

    fun getSupply(barcode: String): LiveData<Supply> {
        return this.mSupplyDao.getSupply(barcode)
    }

    fun count() = this.mSupplyCount

    fun add(supply: Supply) {
        doAsync {
            mSupplyDao.add(supply)
        }
    }

    fun update(supply: Supply) {
        doAsync {
            mSupplyDao.update(supply)
        }
    }

    fun delete(supply: Supply) {
        doAsync {
            mSupplyDao.delete(supply)
        }
    }

}