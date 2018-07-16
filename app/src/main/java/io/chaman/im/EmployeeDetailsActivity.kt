package io.chaman.im

import android.os.Bundle
import com.bumptech.glide.Glide
import com.google.gson.Gson
import io.chaman.im.data.entities.Employee
import io.chaman.im.ui.employee.EmployeeDetailsFragment
import kotlinx.android.synthetic.main.employee_details_activity.*

class EmployeeDetailsActivity : BaseActivity() {

    private lateinit var mEmployee: Employee

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.employee_details_activity)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun configureBundle() {
        this.mEmployee = Gson().fromJson(
                intent.getStringExtra(EmployeeDetailsFragment.ARG_ITEM_ID), Employee::class.java)
    }

    override fun configureUI() {
        setToolbarAsSecondary(this.employeeDetailsToolbar)
        supportActionBar.apply {
            title = mEmployee.firstName + " " + mEmployee.lastName
        }

        Glide.with(this)
                .load(this.mEmployee.imageUrl)
                .into(this.ivEmployeeDetailsImage)
    }

}
