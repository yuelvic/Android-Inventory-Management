package io.chaman.im.ui.employee

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.chaman.im.data.entities.Employee
import io.chaman.im.data.entities.EmployeeReport
import io.chaman.im.data.repository.EmployeeRepository
import io.chaman.im.databinding.AddEmployeeFragmentBinding

class EmployeeViewModel(application: Application) : AndroidViewModel(application) {

    var mEmployeeRepository: EmployeeRepository = EmployeeRepository(application)
    var mEmployees: LiveData<List<Employee>>
    var mEmployeeCount: LiveData<Int>

    init {
        this.mEmployees = this.mEmployeeRepository.getEmployees()
        this.mEmployeeCount = this.mEmployeeRepository.count()
    }

    fun getEmployees() = this.mEmployees

    fun count() = this.mEmployeeCount

    fun addEmployee(binding: AddEmployeeFragmentBinding) {
        val employee = Employee()
        employee.employeeNumber = Integer.parseInt(binding.etEmployeeNumber.text.toString())
        employee.firstName = binding.etEmployeeFirst.text.toString()
        employee.lastName = binding.etEmployeeSecond.text.toString()
        employee.department = binding.spnEmployeeDepartment.selectedItem.toString()
        this.mEmployeeRepository.add(employee)
    }

}
