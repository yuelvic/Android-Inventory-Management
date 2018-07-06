package io.chaman.im.ui.employee

import android.os.Bundle
import android.view.*
import androidx.lifecycle.ViewModelProviders
import io.chaman.im.BaseFragment
import io.chaman.im.R
import kotlinx.android.synthetic.main.employee_fragment.*


class EmployeeFragment : BaseFragment() {

    companion object {
        fun newInstance() = EmployeeFragment()
    }

    private lateinit var viewModel: EmployeeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.employee_fragment, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun configureViewModel() {
        viewModel = ViewModelProviders.of(this).get(EmployeeViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun configureUI() {

    }

    override fun configureBehavior() {
        this.fabEmployee.setOnClickListener {
            navigate(R.id.action_employeeFragment_to_addEmployeeActivity)
        }
    }

}
