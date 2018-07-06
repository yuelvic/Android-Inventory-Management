package io.chaman.im

import android.os.Bundle
import kotlinx.android.synthetic.main.add_item_activity.*

class AddItemActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_item_activity)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun configureUI() {
        setSupportActionBar(this.itemToolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun configureBehavior() {
        super.configureBehavior()
    }

}
