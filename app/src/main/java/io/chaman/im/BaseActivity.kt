package io.chaman.im

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

open class BaseActivity: AppCompatActivity() {

    open fun configureNavController() {

    }

    open fun configureEvent() {

    }

    open fun onReleaseEvent() {

    }

    open fun configureBundle() {

    }

    open fun configureUI() {

    }

    open fun configureBehavior() {

    }

    open fun configureDataBinding(savedInstanceState: Bundle?) {

    }

    open fun configureViewModel() {

    }

    protected fun setToolbarAsSecondary(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configureDataBinding(savedInstanceState)
        configureNavController()
        configureEvent()
    }

    override fun onStart() {
        super.onStart()
        configureViewModel()
        configureBundle()
        configureUI()
        configureBehavior()
    }

    override fun onDestroy() {
        onReleaseEvent()
        super.onDestroy()
    }

}