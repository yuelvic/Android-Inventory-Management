package io.chaman.im.ui.intro

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import io.chaman.im.BaseFragment
import io.chaman.im.IssuanceActivity
import io.chaman.im.MainActivity
import io.chaman.im.R
import kotlinx.android.synthetic.main.intro_fragment.*

class IntroFragment : BaseFragment() {

    companion object {
        fun newInstance() = IntroFragment()
    }

    private lateinit var viewModel: IntroViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.intro_fragment, container, false)
    }

    override fun configureViewModel() {
        viewModel = ViewModelProviders.of(this).get(IntroViewModel::class.java)
    }

    override fun configureBehavior() {
        this.btnIntroLogin.setOnClickListener {
            val intent: Intent = if (this.rbIntroAdmin.isChecked) {
                Intent(context, MainActivity::class.java)
            } else {
                Intent(context, IssuanceActivity::class.java)
            }
            startActivity(intent)
            activity!!.finish()
        }
    }

}
