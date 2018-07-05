package io.chaman.im

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity: AppCompatActivity() {

    open fun configureUI() {

    }

    open fun configureBehavior() {

    }

    open fun configureDataBinding(savedInstanceState: Bundle?) {

    }

    open fun configureViewModel() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configureDataBinding(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        configureViewModel()
        configureUI()
        configureBehavior()
    }

}