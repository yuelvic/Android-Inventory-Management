package io.chaman.im.ui.item

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.esafirm.imagepicker.features.ImagePicker
import com.google.gson.Gson
import io.chaman.im.BaseFragment
import io.chaman.im.R
import io.chaman.im.data.entities.Item
import io.chaman.im.databinding.AddItemFragmentBinding
import kotlinx.android.synthetic.main.add_item_fragment.*

class AddItemFragment : BaseFragment() {

    companion object {
        const val ARG_ITEM_ID = "item_id"
        val TAG = AddItemFragment::class.java.simpleName

        fun newInstance() = AddItemFragment()
    }

    private lateinit var viewModel: RequestViewModel
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.check -> {
                this.viewModel.addRequest(this.mBinding)
                activity!!.finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (ImagePicker.shouldHandle(requestCode, resultCode, data)) {
            val image = ImagePicker.getFirstImageOrNull(data)
            this.mItem.imageUrl = image.path
            this.mBinding.imageUrl = image.path
        }
    }

    override fun configureViewModel() {
        viewModel = ViewModelProviders.of(this).get(RequestViewModel::class.java)
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
            this.mBinding.imageUrl = this.mItem.imageUrl
        }
    }

    override fun configureBehavior() {
        this.ivItemBarcode.setOnClickListener {
            openBarcodeScanner()
        }

        this.ivItemImage.setOnClickListener {
            openImagePicker()
        }
    }

}
