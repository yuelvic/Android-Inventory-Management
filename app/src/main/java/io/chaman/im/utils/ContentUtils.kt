package io.chaman.im.utils

import android.widget.EditText
import android.widget.ImageView

object ContentUtils {

    fun getString(editText: EditText, default: String): String {
        if (editText.text.toString().isEmpty()) return default
        return editText.text.toString()
    }

    fun getString(imageView: ImageView, default: String): String {
        if (imageView.contentDescription.isNullOrEmpty()) return default
        return imageView.contentDescription.toString()
    }

    fun getInt(editText: EditText, default: Int): Int {
        if (editText.text.toString().isEmpty()) return default
        return Integer.parseInt(editText.text.toString())
    }

}