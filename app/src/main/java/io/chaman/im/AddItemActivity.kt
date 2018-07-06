package io.chaman.im

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.chaman.im.ui.item.AddItemFragment

class AddItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_item_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, AddItemFragment.newInstance())
                    .commitNow()
        }
    }

}
