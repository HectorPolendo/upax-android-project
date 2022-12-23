package com.upax.androidproject.ui.view.adapters.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.upax.androidproject.databinding.ActivitySplashBinding
import com.upax.androidproject.ui.viewmodel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        splashViewModel.onCreate(this@SplashActivity)
        subscribeObservers()
    }

    private fun subscribeObservers() {
        splashViewModel.progress.observe(this,{
            binding.progressbar.progress = it
            if(it==100){
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        })
    }
}