package io.chaman.im

import android.content.Context
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication

class BaseApplication: MultiDexApplication() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}