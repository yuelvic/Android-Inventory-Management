package io.chaman.im.ui.custom

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import io.chaman.im.R
import kotlinx.android.synthetic.main.counter_layout.view.*

class CounterView: ConstraintLayout {

    constructor(context: Context) : super(context, null)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs, 0) {
        configureAttributes(attrs)
    }

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.counter_layout, this, false)
        view.id = View.generateViewId()
        val set = ConstraintSet()
        addView(view)

        set.clone(this)
        set.match(view, this)
    }

    fun configureAttributes(attrs: AttributeSet?) {
        val a = context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.CounterView,
                0, 0)

        this.ivCounterUp.setOnClickListener {
            count(true)
        }

        this.ivCounterDown.setOnClickListener {
            count(false)
        }

        try {
            this.ivCounterDown.setBackgroundColor(a.getColor(R.styleable.CounterView_counterColor, Color.WHITE))
            this.ivCounterUp.setBackgroundColor(a.getColor(R.styleable.CounterView_counterColor, Color.WHITE))
        } finally {
            a.recycle()
        }
    }

    private fun count(increase: Boolean) {
        var count = Integer.parseInt(this.etCounterInput.text.toString())
        if (increase) count += 1
        else if (!increase && count > 0) count -= 1
        this.etCounterInput.setText("$count")
    }

}