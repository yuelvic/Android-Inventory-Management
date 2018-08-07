package io.chaman.im

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.xrojan.rxbus.RxBus
import io.chaman.im.data.entities.Employee
import io.chaman.im.databinding.SupplyActivityBinding
import kotlinx.android.synthetic.main.supply_activity.*

class SupplyActivity : BaseActivity() {

    private val TAG = SupplyActivity::class.java.simpleName

    private lateinit var binding: SupplyActivityBinding
    private var mEmployee = Employee()

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

    override fun configureEvent() {
        RxBus.subscribe<Employee>(this) {
            this.mEmployee = it
            onBackPressed()
        }
    }

    override fun onReleaseEvent() {
        RxBus.unsubscribe(this)
    }

    override fun configureNavController() {
        findNavController(R.id.supply_container).addOnNavigatedListener { _, destination ->
            if (!this.mEmployee.firstName.isEmpty() && destination.id == R.id.supplyFragment) {
                RxBus.unsubscribe(this)
                Handler().postDelayed({
                    RxBus.post(this.mEmployee)
                    configureEvent()
                }, 10)
            }
        }
    }

}
