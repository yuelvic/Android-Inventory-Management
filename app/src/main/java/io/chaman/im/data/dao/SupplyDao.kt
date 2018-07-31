package io.chaman.im.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import io.chaman.im.data.entities.Supply

@Dao
interface SupplyDao {

    @Query("SELECT * FROM supply")
    fun getSupplies(): LiveData<List<Supply>>

    @Query("SELECT * FROM supply WHERE id = :supplyId")
    fun getSupply(supplyId: Int): LiveData<Supply>

    @Query("SELECT * FROM supply WHERE barcode = :supplyBarcode")
    fun getSupply(supplyBarcode: String): LiveData<Supply>

    @Query("SELECT COUNT(*) FROM supply")
    fun count(): LiveData<Int>

    @Update
    fun update(supply: Supply)

    @Insert
    fun add(supply: Supply)

    @Delete
    fun delete(supply: Supply)

}