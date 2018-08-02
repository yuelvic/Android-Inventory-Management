package io.chaman.im.ui.employee

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import io.chaman.im.data.entities.Employee
import io.chaman.im.data.repository.EmployeeRepository
import io.chaman.im.databinding.AddEmployeeFragmentBinding
import io.chaman.im.utils.ContentUtils

class AddEmployeeViewModel(application: Application) : AndroidViewModel(application) {

    var mEmployeeRepository: EmployeeRepository = EmployeeRepository(application)
    lateinit var mEmployees: LiveData<List<Employee>>

    init {
        this.mEmployees = this.mEmployeeRepository.getEmployees()
    }

    fun getEmployees() = this.mEmployees

    fun addEmployee(binding: AddEmployeeFragmentBinding) {
        val employee = Employee()
        employee.employeeNumber = ContentUtils.getInt(binding.etEmployeeNumber, 0)
        employee.firstName = ContentUtils.getString(binding.etEmployeeFirst, "John")
        employee.lastName = ContentUtils.getString(binding.etEmployeeSecond, "Doe")
        employee.department = binding.spnEmployeeDepartment.selectedItem.toString()
        employee.imageUrl = ContentUtils.getString(binding.ivEmployeeImage, "")
        if (binding.cbEmployeeRole.isChecked) {
            employee.role = "Admin"
        } else {
            employee.role = "Role"
        }
        this.mEmployeeRepository.add(employee)
    }

}
