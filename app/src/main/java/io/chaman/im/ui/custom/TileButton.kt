package io.chaman.im.ui.custom

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import io.chaman.im.R
import kotlinx.android.synthetic.main.tile_button.view.*


class TileButton: ConstraintLayout {

    private val TAG = TileButton::class.java.simpleName

    constructor(context: Context) : super(context, null)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs, 0) {
        configureAttributes(attrs)
    }

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.tile_button, this, false)
        view.id = View.generateViewId()
        val set = ConstraintSet()
        addView(view)

        set.clone(this)
        set.match(view, this)
    }

    fun configureAttributes(attrs: AttributeSet?) {
        val a = context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.TileButton,
                0, 0)

        try {
            this.tileLayout.setBackgroundColor(a.getColor(R.styleable.TileButton_tileColor, Color.WHITE))
            this.ivTileIcon.setImageDrawable(a.getDrawable(R.styleable.TileButton_tileIcon))
            this.tvTileTitle.text = a.getString(R.styleable.TileButton_tileTitle)

            if (this.tvTileTitle.text == "") {
                this.tvTileTitle.visibility = View.GONE
            }
        } finally {
            a.recycle()
        }
    }

}

fun ConstraintSet.match(view: View, parentView: View) {
    this.connect(view.id, ConstraintSet.TOP, parentView.id, ConstraintSet.TOP)
    this.connect(view.id, ConstraintSet.START, parentView.id, ConstraintSet.START)
    this.connect(view.id, ConstraintSet.END, parentView.id, ConstraintSet.END)
    this.connect(view.id, ConstraintSet.BOTTOM, parentView.id, ConstraintSet.BOTTOM)
}