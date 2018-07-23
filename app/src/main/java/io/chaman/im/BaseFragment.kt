package io.chaman.im

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.esafirm.imagepicker.features.ImagePicker
import com.esafirm.imagepicker.model.Image
import com.google.android.material.bottomsheet.BottomSheetDialog
import io.chaman.im.ui.custom.ImagePickerBottomSheet

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

    protected fun openBottomSheet(resId: Int) {
        val bottomSheetDialog = BottomSheetDialog(this.activity!!)
        val sheetView = activity!!.layoutInflater.inflate(resId, null)
        bottomSheetDialog.setContentView(sheetView)
        bottomSheetDialog.show()
    }

    protected fun openImagePicker() {
        ImagePicker.create(this)
                .theme(R.style.AppTheme)
                .limit(1)
                .includeVideo(false)
                .start()
    }

    protected fun saveState() {

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        configureViewModel()
        configureBundle()
        configureUI()
        configureBehavior()
    }

}