package io.chaman.im.ui.issue

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import io.chaman.im.BaseFragment
import io.chaman.im.R
import io.chaman.im.adapters.ItemAdapter
import io.chaman.im.databinding.IssueFragmentBinding
import io.chaman.im.ui.item.SupplyViewModel
import kotlinx.android.synthetic.main.issue_fragment.*


class IssueFragment : BaseFragment() {

    companion object {
        fun newInstance() = IssueFragment()
    }

    private lateinit var binding: IssueFragmentBinding
    private lateinit var viewModel: SupplyViewModel
    private lateinit var mIssueAdapter: ItemAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return configureDataBinding(inflater, container)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_item_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun configureDataBinding(inflater: LayoutInflater, container: ViewGroup?): View? {
        this.binding = DataBindingUtil.inflate(inflater, R.layout.issue_fragment, container, false)
        return binding.root
    }

    override fun configureViewModel() {
        viewModel = ViewModelProviders.of(this).get(SupplyViewModel::class.java)
        viewModel.getSupplies().observe(this, Observer {
            if (it != null) {
                mIssueAdapter.setSupplies(it)
            }
        })
    }

    override fun configureUI() {
        this.mIssueAdapter = ItemAdapter(this.context!!)
        this.mIssueAdapter.toIssue(true)
        this.rvIssue.adapter = mIssueAdapter
        this.rvIssue.layoutManager = LinearLayoutManager(context)
    }

}
