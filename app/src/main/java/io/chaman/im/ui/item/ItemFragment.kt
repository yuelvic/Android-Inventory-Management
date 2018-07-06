package io.chaman.im.ui.item

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import io.chaman.im.BaseFragment
import io.chaman.im.R
import io.chaman.im.adapters.ItemAdapter
import io.chaman.im.databinding.ItemFragmentBinding
import kotlinx.android.synthetic.main.item_fragment.*


class ItemFragment : BaseFragment() {

    private lateinit var binding: ItemFragmentBinding
    private lateinit var mItemAdapter: ItemAdapter

    companion object {
        fun newInstance() = ItemFragment()
    }

    private lateinit var viewModel: ItemViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return configureDataBinding(inflater, container)
    }

    private fun configureDataBinding(inflater: LayoutInflater, container: ViewGroup?): View? {
        this.binding = DataBindingUtil.inflate(inflater, R.layout.item_fragment, container, false)
        return binding.root
    }

    override fun configureViewModel() {
        viewModel = ViewModelProviders.of(this).get(ItemViewModel::class.java)
        viewModel.getItems().observe(this, Observer {
            if (it != null) {
                mItemAdapter.setItems(it)
            }
        })
    }

    override fun configureUI() {
        this.mItemAdapter = ItemAdapter(this.context!!)
        this.rvItem.adapter = this.mItemAdapter
        this.rvItem.layoutManager = LinearLayoutManager(context)
    }

    override fun configureBehavior() {
        super.configureBehavior()
    }

}
