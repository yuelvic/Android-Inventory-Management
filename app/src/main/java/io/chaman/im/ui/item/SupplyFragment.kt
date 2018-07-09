package io.chaman.im.ui.item

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.chaman.im.BaseFragment
import io.chaman.im.R

class SupplyFragment : BaseFragment() {

    companion object {
        const val ARG_ITEM_ID = "item_id"

        fun newInstance() = SupplyFragment()
    }

    private lateinit var viewModel: SupplyViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.supply_fragment, container, false)
    }

    override fun configureViewModel() {
        viewModel = ViewModelProviders.of(this).get(SupplyViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
