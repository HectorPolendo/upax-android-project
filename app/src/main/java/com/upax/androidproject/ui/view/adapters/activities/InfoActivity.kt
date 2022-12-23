package com.upax.androidproject.ui.view.adapters.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.upax.androidproject.R
import com.upax.androidproject.databinding.ActivityInfoBinding
import com.upax.androidproject.databinding.ActivityMainBinding

class InfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
    }
}