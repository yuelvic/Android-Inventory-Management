package io.chaman.im.ui.custom

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import com.google.android.material.bottomsheet.BottomSheetDialog
import io.chaman.im.R

class ImagePickerBottomSheet : BottomSheetDialog {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context,0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.image_picker)
    }

}