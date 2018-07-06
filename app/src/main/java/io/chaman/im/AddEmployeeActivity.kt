package io.chaman.im

import android.os.Bundle
import kotlinx.android.synthetic.main.add_employee_activity.*

class AddEmployeeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_employee_activity)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun configureUI() {
        setToolbarAsSecondary(this.employeeToolbar)
    }

}
