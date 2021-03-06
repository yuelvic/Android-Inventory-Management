package io.chaman.im.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.chaman.im.data.entities.Request

@Dao
interface RequestDao {

    @Query("SELECT * FROM request")
    fun getRequests(): LiveData<List<Request>>

    @Query("SELECT COUNT(*) FROM request")
    fun count(): LiveData<Int>

    @Insert
    fun add(request: Request)

    @Delete
    fun delete(request: Request)

}