package io.chaman.im

import androidx.appcompat.app.AppCompatActivity

open class BaseActivity: AppCompatActivity() {

    open fun configureUI() {

    }

    open fun configureBehavior() {

    }

    open fun configureViewModel() {

    }

    override fun onStart() {
        super.onStart()
        configureViewModel()
        configureUI()
        configureBehavior()
    }

}