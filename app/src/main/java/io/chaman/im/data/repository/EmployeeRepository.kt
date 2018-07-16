package io.chaman.im.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import io.chaman.im.data.dao.EmployeeDao
import io.chaman.im.data.database.EmployeeDatabase
import io.chaman.im.data.entities.Employee
import org.jetbrains.anko.doAsync

class EmployeeRepository(application: Application) {

    lateinit var mEmployeeDao: EmployeeDao
    lateinit var mEmployees: LiveData<List<Employee>>

    init {
        val db = EmployeeDatabase.getDatabase(application)
        this.mEmployeeDao = db!!.employeeDao()
        this.mEmployees = this.mEmployeeDao.getEmployees()
    }

    fun getEmployees(): LiveData<List<Employee>> {
        return this.mEmployees
    }

    fun add(employee: Employee) {
        doAsync {
            mEmployeeDao.add(employee)
        }
    }

}