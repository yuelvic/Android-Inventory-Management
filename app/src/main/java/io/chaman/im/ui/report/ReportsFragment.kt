package io.chaman.im.ui.report

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.lifecycle.ViewModelProviders
import io.chaman.im.BaseFragment
import io.chaman.im.R
import java.util.*


class ReportsFragment : BaseFragment(), DatePickerDialog.OnDateSetListener {

    companion object {
        fun newInstance() = ReportsFragment()
    }

    private lateinit var viewModel: ReportsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.reports_fragment, container, false)
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {

    }

    override fun configureViewModel() {
        viewModel = ViewModelProviders.of(this).get(ReportsViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun configureUI() {
        showDatePicker()
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(context, this,
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
        datePickerDialog.show()
    }

}
