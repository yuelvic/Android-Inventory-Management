package io.chaman.im.ui.item

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.google.gson.Gson
import io.chaman.im.BaseFragment
import io.chaman.im.R
import io.chaman.im.data.entities.Item
import io.chaman.im.databinding.AddItemFragmentBinding
import kotlinx.android.synthetic.main.add_item_fragment.*

class AddItemFragment : BaseFragment() {

    companion object {
        const val ARG_ITEM_ID = "item_id"

        fun newInstance() = AddItemFragment()
    }

    private lateinit var viewModel: AddItemViewModel
    private lateinit var mBinding: AddItemFragmentBinding
    private var mItem = Item()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        setHasOptionsMenu(true)
        return configureDataBinding(inflater, container)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater) {
        inflater.inflate(R.menu.check_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun configureViewModel() {
        viewModel = ViewModelProviders.of(this).get(AddItemViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun configureBundle() {
        if (activity!!.intent.hasExtra(ARG_ITEM_ID)) {
            this.mItem = Gson().fromJson(
                    activity?.intent?.getStringExtra(ARG_ITEM_ID), Item::class.java)
        }
    }

    private fun configureDataBinding(inflater: LayoutInflater, container: ViewGroup?): View {
        this.mBinding = DataBindingUtil.inflate<AddItemFragmentBinding>(inflater,
                R.layout.add_item_fragment, container, false).apply {
            setLifecycleOwner(this@AddItemFragment)
        }
        return this.mBinding.root
    }

    override fun configureUI() {
        if (this.mItem.name != "") {
            setTitle("Edit Item")
            this.mBinding.item = this.mItem
        }
    }

    override fun configureBehavior() {
        this.ivItemImage.setOnClickListener {
            openImagePicker()
        }
    }

}
