package io.chaman.im.ui.report

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import io.chaman.im.BaseFragment
import io.chaman.im.R
import io.chaman.im.databinding.ReportsFragmentBinding
import io.chaman.im.ui.employee.EmployeeViewModel
import io.chaman.im.ui.item.RequestViewModel
import io.chaman.im.ui.item.SupplyViewModel
import kotlinx.android.synthetic.main.reports_fragment.*
import java.util.*


class ReportsFragment : BaseFragment(), DatePickerDialog.OnDateSetListener {

    companion object {
        fun newInstance() = ReportsFragment()
    }

    private lateinit var employeeViewModel: EmployeeViewModel
    private lateinit var requestViewModel: RequestViewModel
    private lateinit var supplyViewModel: SupplyViewModel
    private lateinit var mBinding: ReportsFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return configureDataBinding(inflater, container)
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {

    }

    private fun configureDataBinding(inflater: LayoutInflater, container: ViewGroup?): View {
        this.mBinding = DataBindingUtil.inflate(inflater, R.layout.reports_fragment, container, false)
        return this.mBinding.root
    }

    override fun configureViewModel() {
        this.employeeViewModel = ViewModelProviders.of(this).get(EmployeeViewModel::class.java)
        this.requestViewModel = ViewModelProviders.of(this).get(RequestViewModel::class.java)
        this.supplyViewModel = ViewModelProviders.of(this).get(SupplyViewModel::class.java)

        updateEmployeeReports()
        updateRequestReports()
        updateSupplyReports()
    }

    override fun configureUI() {
        setTitle(getString(R.string.text_admin_dashboard))
    }

    private fun updateEmployeeReports() {
        this.employeeViewModel.count().observe(this, androidx.lifecycle.Observer {
            this.tileReportEmployeeCount.setValue(it)
        })
    }

    private fun updateRequestReports() {
        this.requestViewModel.count().observe(this, androidx.lifecycle.Observer {
            this.tileReportRequestCount.setValue(it)
        })
    }

    private fun updateSupplyReports() {
        this.supplyViewModel.count().observe(this, androidx.lifecycle.Observer {
            this.tileReportSupplyCount.setValue(it)
        })
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(context, this,
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
        datePickerDialog.show()
    }

}
