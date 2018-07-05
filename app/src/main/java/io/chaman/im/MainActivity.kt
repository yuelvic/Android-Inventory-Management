package io.chaman.im

import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import io.chaman.im.databinding.MainActivityBinding
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : BaseActivity() {

    private lateinit var binding: MainActivityBinding
    private lateinit var drawerLayout: DrawerLayout

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,
                Navigation.findNavController(this, R.id.container))
                || super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(drawerLayout,
                Navigation.findNavController(this, R.id.container))
    }

    override fun configureDataBinding(savedInstanceState: Bundle?) {
        this.binding = DataBindingUtil
                .setContentView(this, R.layout.main_activity)
        this.drawerLayout = binding.drawerLayout
    }

    override fun configureUI() {
        val navController = Navigation.findNavController(this, R.id.container)

        setSupportActionBar(toolbar)

        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupWithNavController(this.binding.navigationView, navController)
    }

}
