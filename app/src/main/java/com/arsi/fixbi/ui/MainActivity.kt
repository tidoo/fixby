package com.arsi.fixbi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import com.arsi.fixbi.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        /**
         * using new splash screen api with backward compatibility
         * this splash screen is handled by a theme only and nothing else
         * there is a difference between show time of the screen,
         * ----depending on weather its a cold start/hot start/warm start.
         * ----which is handled internally and its not in our control
         * instance can be used to perform other handling such as animation ending listener
         */
        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        init()

    }

    fun init() {

    }
}

