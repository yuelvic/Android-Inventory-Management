package io.chaman.im.ui.employee

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProviders
import io.chaman.im.BaseFragment
import io.chaman.im.R
import kotlinx.android.synthetic.main.add_employee_fragment.*

class AddEmployeeFragment : BaseFragment() {

    companion object {
        fun newInstance() = AddEmployeeFragment()
    }

    private lateinit var viewModel: AddEmployeeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.add_employee_fragment, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater) {
        inflater.inflate(R.menu.check_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun configureViewModel() {
        viewModel = ViewModelProviders.of(this).get(AddEmployeeViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun configureUI() {
        // Department spinner
        val spinnerAdapter = ArrayAdapter.createFromResource(context,
                R.array.text_department_array, android.R.layout.simple_spinner_item)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        this.spnEmployeeDepartment.adapter = spinnerAdapter
    }

}
