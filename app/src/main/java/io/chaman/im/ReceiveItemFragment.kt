package io.chaman.im

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.google.gson.Gson
import io.chaman.im.data.entities.Request
import io.chaman.im.databinding.ReceiveItemFragmentBinding


class ReceiveItemFragment : BaseFragment() {

    companion object {
        const val ARG_ITEM_ID = "request_id"
        val TAG = ReceiveItemFragment::class.java.simpleName

        fun newInstance() = ReceiveItemFragment()
    }

    private lateinit var viewModel: ReceiveItemViewModel
    private lateinit var mBinding: ReceiveItemFragmentBinding

    private lateinit var mRequest: Request

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
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
                this.viewModel.addSupply(this.mBinding, this.mRequest)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun configureDataBinding(inflater: LayoutInflater, container: ViewGroup?): View {
        this.mBinding = DataBindingUtil.inflate(inflater, R.layout.receive_item_fragment, container, false)
        return this.mBinding.root
    }

    override fun configureViewModel() {
        viewModel = ViewModelProviders.of(this).get(ReceiveItemViewModel::class.java)
    }

    override fun configureBundle() {
        if (arguments != null) {
            val item = arguments!!.getString(ARG_ITEM_ID)
            this.mRequest = Gson().fromJson(item, Request::class.java)
            this.mBinding.request = this.mRequest
        }
    }

    override fun configureUI() {

    }

}
