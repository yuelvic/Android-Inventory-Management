package io.chaman.im.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import io.chaman.im.data.dao.EmployeeDao
import io.chaman.im.data.database.EmployeeDatabase
import io.chaman.im.data.entities.Employee
import org.jetbrains.anko.doAsync

class EmployeeRepository(application: Application) {

    var mEmployeeDao: EmployeeDao
    var mEmployees: LiveData<List<Employee>>
    var mEmployeeCount: LiveData<Int>

    init {
        val db = EmployeeDatabase.getDatabase(application)
        this.mEmployeeDao = db!!.employeeDao()
        this.mEmployees = this.mEmployeeDao.getEmployees()
        this.mEmployeeCount = this.mEmployeeDao.count()
    }

    fun getEmployees(): LiveData<List<Employee>> {
        return this.mEmployees
    }

    fun count(): LiveData<Int> {
        return this.mEmployeeCount
    }

    fun add(employee: Employee) {
        doAsync {
            mEmployeeDao.add(employee)
        }
    }

}