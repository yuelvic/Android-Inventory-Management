package io.chaman.im

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
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

        val navController = Navigation.findNavController(this, R.id.container)
        NavigationUI.setupWithNavController(this.bottomNavigationBar, navController)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.container).navigateUp()
    }

    override fun onBackPressed() {
        findNavController(R.id.container).navigateUp()
    }

}
