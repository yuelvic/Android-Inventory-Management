package io.chaman.im.ui.item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import io.chaman.im.BaseFragment
import io.chaman.im.R
import io.chaman.im.adapters.RequestAdapter
import io.chaman.im.databinding.RequestFragmentBinding
import kotlinx.android.synthetic.main.request_fragment.*


class RequestFragment : BaseFragment() {

    private lateinit var binding: RequestFragmentBinding
    private lateinit var mRequestAdapter: RequestAdapter

    companion object {
        fun newInstance() = RequestFragment()
    }

    private lateinit var viewModel: RequestViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return configureDataBinding(inflater, container)
    }

    private fun configureDataBinding(inflater: LayoutInflater, container: ViewGroup?): View {
        this.binding = DataBindingUtil.inflate(inflater, R.layout.request_fragment, container, false)
        return binding.root
    }

    override fun configureViewModel() {
        viewModel = ViewModelProviders.of(this).get(RequestViewModel::class.java)
        viewModel.getRequests().observe(this, Observer {
            if (it != null) {
                this.mRequestAdapter.setRequests(it)
            }
        })
    }

    override fun configureUI() {
        setTitle(getString(R.string.text_admin_request))

        this.mRequestAdapter = RequestAdapter(context)
        this.rvRequest.adapter = this.mRequestAdapter
        this.rvRequest.layoutManager = LinearLayoutManager(context)
    }

    override fun configureBehavior() {
        this.fabRequest.setOnClickListener {
            navigate(R.id.action_requestFragment_to_addItemActivity)
        }
    }

}
