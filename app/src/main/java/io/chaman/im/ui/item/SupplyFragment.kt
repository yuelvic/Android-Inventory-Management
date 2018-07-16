package io.chaman.im.ui.item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.google.gson.Gson
import io.chaman.im.BaseFragment
import io.chaman.im.R
import io.chaman.im.data.entities.Item
import io.chaman.im.databinding.SupplyFragmentBinding
import kotlinx.android.synthetic.main.supply_fragment.*

class SupplyFragment : BaseFragment() {

    companion object {
        const val ARG_ITEM_ID = "item_id"

        fun newInstance() = SupplyFragment()
    }

    private lateinit var binding: SupplyFragmentBinding
    private lateinit var viewModel: SupplyViewModel
    private lateinit var mItem: Item

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return configureDataBinding(inflater, container)
    }

    private fun configureDataBinding(inflater: LayoutInflater, container: ViewGroup?): View {
        this.binding = DataBindingUtil.inflate<SupplyFragmentBinding>(inflater,
                R.layout.supply_fragment, container, false)
        return this.binding.root
    }

    override fun configureViewModel() {
        viewModel = ViewModelProviders.of(this).get(SupplyViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun configureBundle() {
        this.mItem = Gson().fromJson(activity!!.intent
                .getStringExtra(ARG_ITEM_ID), Item::class.java)
    }

    override fun configureUI() {
        this.binding.item = this.mItem

        Glide.with(this.context!!)
                .load(this.mItem.imageUrl)
                .into(this.ivSupplyImage)
    }

    override fun configureBehavior() {
        this.tvSupplyEmployee.setOnClickListener {

        }
    }

}
