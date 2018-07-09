package io.chaman.im.ui.employee

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import io.chaman.im.BaseFragment
import io.chaman.im.R
import io.chaman.im.adapters.EmployeeAdapter
import io.chaman.im.databinding.EmployeeFragmentBinding
import kotlinx.android.synthetic.main.employee_fragment.*


class EmployeeFragment : BaseFragment() {

    private lateinit var binding: EmployeeFragmentBinding
    private lateinit var mEmployeeAdapter: EmployeeAdapter

    companion object {
        fun newInstance() = EmployeeFragment()
    }

    private lateinit var viewModel: EmployeeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return configureDataBinding(inflater, container)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_employee_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun configureDataBinding(inflater: LayoutInflater, container: ViewGroup?): View? {
        this.binding = DataBindingUtil.inflate(inflater, R.layout.employee_fragment, container, false)
        return binding.root
    }

    override fun configureViewModel() {
        viewModel = ViewModelProviders.of(this).get(EmployeeViewModel::class.java)
        viewModel.getEmployees().observe(this, Observer {
            if (it != null) {
                this.mEmployeeAdapter.setEmployees(it)
            }
        })
    }

    override fun configureUI() {
        this.mEmployeeAdapter = EmployeeAdapter(context)
        this.rvEmployee.adapter = this.mEmployeeAdapter
        this.rvEmployee.layoutManager = GridLayoutManager(context, 2,
                GridLayoutManager.VERTICAL, false)
    }

    override fun configureBehavior() {
        this.fabEmployee.setOnClickListener {
            navigate(R.id.action_employeeFragment_to_addEmployeeActivity)
        }
    }

}
