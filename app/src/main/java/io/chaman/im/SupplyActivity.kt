package io.chaman.im

import android.os.Bundle
import kotlinx.android.synthetic.main.supply_activity.*

class SupplyActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.supply_activity)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun configureUI() {
        setToolbarAsSecondary(this.supplyToolbar)
    }

}
