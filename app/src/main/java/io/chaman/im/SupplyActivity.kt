package io.chaman.im

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.chaman.im.ui.item.SupplyFragment

class SupplyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.supply_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, SupplyFragment.newInstance())
                    .commitNow()
        }
    }

}
