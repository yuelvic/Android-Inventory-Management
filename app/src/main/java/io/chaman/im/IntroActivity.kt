package io.chaman.im

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.chaman.im.ui.intro.IntroFragment

class IntroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intro_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, IntroFragment.newInstance())
                    .commitNow()
        }
    }

}
