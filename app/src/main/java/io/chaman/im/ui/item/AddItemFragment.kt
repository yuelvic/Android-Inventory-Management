package io.chaman.im.ui.item

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.chaman.im.R

class AddItemFragment : Fragment() {

    companion object {
        fun newInstance() = AddItemFragment()
    }

    private lateinit var viewModel: AddItemViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.add_item_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddItemViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
