package com.luckyfriday.netflixclone.presentation.splash

import android.animation.Animator
import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.airbnb.lottie.LottieAnimationView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.luckyfriday.netflixclone.R
import com.luckyfriday.netflixclone.presentation.MainActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        setupStatusAndNavBarColor()

        val animationView = findViewById<LottieAnimationView>(R.id.lottie)
        animationView.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationCancel(animation: Animator) {
            }

            override fun onAnimationEnd(animation: Animator) {
                lifecycleScope.launch {
                    delay(2000)
                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                    finish()
                }
            }

            override fun onAnimationRepeat(animation: Animator) {
            }

            override fun onAnimationStart(animation: Animator) {
            }
        })
    }

    private fun setupStatusAndNavBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window?.let {
                it.statusBarColor = Color.BLACK
                it.navigationBarColor = Color.BLACK
            }
        } else {
            window?.let {
                it.statusBarColor = Color.BLACK
            }
        }
    }
}

