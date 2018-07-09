package io.chaman.im.ui.custom

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import io.chaman.im.R
import kotlinx.android.synthetic.main.tile_report.view.*


class TileReport: ConstraintLayout {

    private val TAG = TileReport::class.java.simpleName

    constructor(context: Context) : super(context, null)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs, 0) {
        configureAttributes(attrs)
    }

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.tile_report, this, false)
        view.id = View.generateViewId()
        val set = ConstraintSet()
        addView(view)

        set.clone(this)
        set.match(view, this)
    }

    fun configureAttributes(attrs: AttributeSet?) {
        val a = context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.TileReport,
                0, 0)

        try {
            this.tileReportLine.setBackgroundColor(a.getColor(R.styleable.TileReport_tileReportLineColor, Color.WHITE))
            this.tvTileReportTitle.text = a.getString(R.styleable.TileReport_tileReportTitle)
            this.tvTileReportValue.text = a.getString(R.styleable.TileReport_tileReportValue)
        } finally {
            a.recycle()
        }
    }

}