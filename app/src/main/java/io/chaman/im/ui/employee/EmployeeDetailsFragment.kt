package io.chaman.im.ui.employee

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import io.chaman.im.BaseFragment
import io.chaman.im.R

class EmployeeDetailsFragment : BaseFragment() {

    companion object {
        const val ARG_ITEM_ID = "employee_id"

        fun newInstance() = EmployeeDetailsFragment()
    }

    private lateinit var viewModel: EmployeeDetailsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.employee_details_fragment, container, false)
    }

    override fun configureViewModel() {
        viewModel = ViewModelProviders.of(this).get(EmployeeDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun configureUI() {

    }

}
