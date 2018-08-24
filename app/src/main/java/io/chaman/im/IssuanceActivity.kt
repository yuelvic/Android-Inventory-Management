package io.chaman.im

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_issuance.*

class IssuanceActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_issuance)
    }

    override fun configureUI() {
        setSupportActionBar(this.employeeToolbar)
    }

}
