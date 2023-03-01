package com.main.musicplayerway

import android.os.Bundle
import com.library.musicplayerway.R
import com.main.core.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}