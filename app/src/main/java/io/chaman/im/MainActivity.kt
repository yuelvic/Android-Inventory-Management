package io.chaman.im

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import io.chaman.im.databinding.MainActivityBinding
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : BaseActivity() {

    private lateinit var binding: MainActivityBinding

    override fun configureDataBinding(savedInstanceState: Bundle?) {
        this.binding = DataBindingUtil
                .setContentView(this, R.layout.main_activity)
    }

    override fun configureUI() {
        setSupportActionBar(toolbar)
    }

}
