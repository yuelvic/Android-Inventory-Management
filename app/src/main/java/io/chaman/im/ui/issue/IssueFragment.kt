package io.chaman.im.ui.issue

import android.os.Bundle
import android.view.*
import androidx.lifecycle.ViewModelProviders
import io.chaman.im.BaseFragment
import io.chaman.im.R


class IssueFragment : BaseFragment() {

    companion object {
        fun newInstance() = IssueFragment()
    }

    private lateinit var viewModel: IssueViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.issue_fragment, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater) {
        inflater.inflate(R.menu.issue_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun configureViewModel() {
        viewModel = ViewModelProviders.of(this).get(IssueViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
