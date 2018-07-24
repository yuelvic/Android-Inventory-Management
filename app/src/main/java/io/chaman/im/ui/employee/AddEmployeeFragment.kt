package io.chaman.im.ui.employee

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.esafirm.imagepicker.features.ImagePicker
import io.chaman.im.BaseFragment
import io.chaman.im.R
import io.chaman.im.data.entities.Employee
import io.chaman.im.databinding.AddEmployeeFragmentBinding
import kotlinx.android.synthetic.main.add_employee_fragment.*

class AddEmployeeFragment : BaseFragment() {

    companion object {
        val TAG = AddEmployeeFragment::class.java.simpleName
        fun newInstance() = AddEmployeeFragment()
    }

    private lateinit var mBinding: AddEmployeeFragmentBinding
    private lateinit var viewModel: AddEmployeeViewModel

    private lateinit var mEmployee: Employee

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        setHasOptionsMenu(true)
        return configureDataBinding(inflater, container)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater) {
        inflater.inflate(R.menu.check_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.check -> {
                this.viewModel.addEmployee(this.mBinding)
                activity!!.finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (ImagePicker.shouldHandle(requestCode, resultCode, data)) {
            val image = ImagePicker.getFirstImageOrNull(data)
            this.mEmployee.imageUrl = image.path
//            this.mBinding.imageUrl = image.path
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    override fun configureViewModel() {
        this.viewModel = ViewModelProviders.of(this).get(AddEmployeeViewModel::class.java)
        this.viewModel.getEmployees().observe(this, Observer {
            if (it != null) {
                Log.d(TAG, it.toString())
            }
        })
    }

    private fun configureDataBinding(inflater: LayoutInflater, container: ViewGroup?): View {
        this.mBinding = DataBindingUtil.inflate<AddEmployeeFragmentBinding>(
                inflater, R.layout.add_employee_fragment, container, false).apply {
            setLifecycleOwner(this@AddEmployeeFragment)
        }
        return this.mBinding.root
    }

    override fun configureUI() {
        // Department spinner
        val spinnerAdapter = ArrayAdapter.createFromResource(context,
                R.array.text_department_array, android.R.layout.simple_spinner_item)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        this.spnEmployeeDepartment.adapter = spinnerAdapter
    }

    override fun configureBehavior() {
        this.ivEmployeeImage.setOnClickListener {
            openImagePicker()
        }
    }

}
