package io.chaman.im.ui.item

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
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
        setHasOptionsMenu(true)
        return configureDataBinding(inflater, container)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
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
        this.fabItem.setOnClickListener {
            navigate(R.id.action_itemFragment_to_addItemActivity)
        }
    }

}
