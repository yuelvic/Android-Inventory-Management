package io.chaman.im

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.add_item_activity.*

class AddItemActivity : BaseActivity() {

    val TAG = AddItemActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_item_activity)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents != null) {
                Log.d(TAG, result.contents)
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun configureUI() {
        setToolbarAsSecondary(this.itemToolbar)
    }

    override fun configureBehavior() {
        super.configureBehavior()
    }

}
