package io.chaman.im

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.zxing.integration.android.IntentIntegrator
import com.xrojan.rxbus.RxBus
import io.chaman.im.data.entities.Barcode
import io.chaman.im.databinding.MainActivityBinding
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : BaseActivity() {

    private val TAG = MainActivity::class.java.simpleName

    private lateinit var binding: MainActivityBinding

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents != null) {
                RxBus.post(Barcode(result.contents))
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

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
