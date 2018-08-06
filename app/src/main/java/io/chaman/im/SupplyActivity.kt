package io.chaman.im

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import io.chaman.im.databinding.SupplyActivityBinding
import kotlinx.android.synthetic.main.supply_activity.*

class SupplyActivity : BaseActivity() {

    private lateinit var binding: SupplyActivityBinding

    override fun configureDataBinding(savedInstanceState: Bundle?) {
        this.binding = DataBindingUtil
                .setContentView(this, R.layout.supply_activity)
    }

    override fun configureUI() {
        setSupportActionBar(this.supplyToolbar)

        val navController = Navigation.findNavController(this, R.id.supply_container)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(null, findNavController(R.id.supply_container))
    }

    override fun onBackPressed() {
        if (!NavigationUI.navigateUp(null, findNavController(R.id.supply_container))) {
            super.onBackPressed()
        }
    }

}
