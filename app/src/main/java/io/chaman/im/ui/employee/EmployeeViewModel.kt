package io.chaman.im.ui.employee

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import io.chaman.im.data.entities.Employee
import io.chaman.im.data.MockData

class EmployeeViewModel : ViewModel() {

    private val employeeList = MutableLiveData<List<Employee>>()

    init {
        employeeList.postValue(MockData.provideEmployees())
    }

    fun getEmployees() = employeeList

}
