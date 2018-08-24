package io.chaman.im.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.chaman.im.data.entities.Employee

@Dao
interface EmployeeDao {

    @Query("SELECT * FROM employee")
    fun getEmployees(): LiveData<List<Employee>>

    @Insert
    fun add(employee: Employee)

    @Query("SELECT COUNT(*) FROM employee")
    fun count(): LiveData<Int>

}