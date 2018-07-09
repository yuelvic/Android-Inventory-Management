package io.chaman.im.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import io.chaman.im.BaseFragment
import io.chaman.im.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : BaseFragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun configureViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun configureBehavior() {
        this.tileAdminItems.setOnClickListener {
            navigate(R.id.action_mainFragment_to_itemFragment)
        }

        this.tileAdminEmployee.setOnClickListener {
            navigate(R.id.action_mainFragment_to_employeeFragment)
        }

        this.tileAdminReports.setOnClickListener {
            navigate(R.id.action_mainFragment_to_reportsFragment)
        }
    }

}
