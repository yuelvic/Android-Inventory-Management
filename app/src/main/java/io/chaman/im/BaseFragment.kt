package io.chaman.im

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

open class BaseFragment: Fragment() {

    open fun configureBundle() {

    }

    open fun configureUI() {

    }

    open fun configureBehavior() {

    }

    open fun configureViewModel() {

    }

    /**
     * Navigate to another view
     * @param resId resource id of view
     */
    protected fun navigate(resId: Int) {
        view?.let {
            Navigation.findNavController(it)
                    .navigate(resId)
        }
    }

    /**
     * Sets toolbar title
     * @param title Title
     */
    protected fun setTitle(title: String) {
        activity!!.title = title
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        configureViewModel()
        configureBundle()
        configureUI()
        configureBehavior()
    }

}