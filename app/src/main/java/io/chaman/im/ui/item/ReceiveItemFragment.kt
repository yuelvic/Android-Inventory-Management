package io.chaman.im.ui.item

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.google.gson.Gson
import com.xrojan.rxbus.RxBus
import io.chaman.im.BaseFragment
import io.chaman.im.R
import io.chaman.im.data.entities.Barcode
import io.chaman.im.data.entities.Request
import io.chaman.im.databinding.ReceiveItemFragmentBinding


class ReceiveItemFragment : BaseFragment() {

    companion object {
        const val ARG_ITEM_ID = "request_id"
        val TAG = ReceiveItemFragment::class.java.simpleName

        fun newInstance() = ReceiveItemFragment()
    }

    private lateinit var supplyViewModel: SupplyViewModel
    private lateinit var requestViewModel: RequestViewModel
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
                this.supplyViewModel.addSupply(this.mBinding, this.mRequest)
                this.requestViewModel.delete(this.mRequest)
                pop()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun configureEvent() {
        RxBus.subscribe<Barcode>(this) {
            this.mBinding.barcode = it.code
        }
    }

    override fun onReleaseEvent() {
        RxBus.unsubscribe(this)
    }

    private fun configureDataBinding(inflater: LayoutInflater, container: ViewGroup?): View {
        this.mBinding = DataBindingUtil.inflate(inflater, R.layout.receive_item_fragment, container, false)
        return this.mBinding.root
    }

    override fun configureViewModel() {
        supplyViewModel = ViewModelProviders.of(this).get(SupplyViewModel::class.java)
        requestViewModel = ViewModelProviders.of(this).get(RequestViewModel::class.java)
    }

    override fun configureBundle() {
        if (arguments != null) {
            val item = arguments!!.getString(ARG_ITEM_ID)
            this.mRequest = Gson().fromJson(item, Request::class.java)
            this.mBinding.request = this.mRequest
        }
    }

    override fun configureBehavior() {
        this.mBinding.ivReceiveBarcode.setOnClickListener {
            openBarcodeScanner()
        }
    }

}
