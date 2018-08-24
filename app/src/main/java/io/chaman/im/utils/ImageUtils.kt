package io.chaman.im.utils

import com.bumptech.glide.request.RequestOptions

class ImageUtils {

    companion object {
        fun getRequestConfig(placeHolder: Int, error: Int): RequestOptions {
            val requestOptions = RequestOptions()
            requestOptions.placeholder(placeHolder)
            requestOptions.error(error)
            return requestOptions
        }
    }

}