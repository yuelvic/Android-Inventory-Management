package io.chaman.im.ui.employee

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import io.chaman.im.data.entities.Employee
import io.chaman.im.data.repository.EmployeeRepository
import io.chaman.im.databinding.AddEmployeeFragmentBinding

class AddEmployeeViewModel(application: Application) : AndroidViewModel(application) {

    var mEmployeeRepository: EmployeeRepository = EmployeeRepository(application)
    lateinit var mEmployees: LiveData<List<Employee>>

    init {
        this.mEmployees = this.mEmployeeRepository.getEmployees()
    }

    fun getEmployees() = this.mEmployees

    fun addEmployee(binding: AddEmployeeFragmentBinding) {
        val employee = Employee()
        employee.employeeNumber = Integer.parseInt(binding.etEmployeeNumber.text.toString())
        employee.firstName = binding.etEmployeeFirst.text.toString()
        employee.lastName = binding.etEmployeeSecond.text.toString()
        employee.department = binding.spnEmployeeDepartment.selectedItem.toString()
        employee.imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSexIAm6UsLd1QXeR9AV3IPROzLLjFb58-FS4BapCZVfHbDRJunfw"
        this.mEmployeeRepository.add(employee)
    }

}
