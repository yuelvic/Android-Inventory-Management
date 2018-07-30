package io.chaman.im.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.chaman.im.data.entities.Supply

@Dao
interface SupplyDao {

    @Query("SELECT * FROM supply")
    fun getSupplies(): LiveData<List<Supply>>

    @Query("SELECT COUNT(*) FROM supply")
    fun count(): LiveData<Int>

    @Insert
    fun add(supply: Supply)

    @Delete
    fun delete(supply: Supply)

}