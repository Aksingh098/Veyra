package com.example.veyra

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.veyra.presentation.onBoarding.OnBoardingScreen
import com.example.veyra.presentation.splash.SplashScreen
import com.example.veyra.ui.theme.VeyraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VeyraTheme {
                OnBoardingScreen()
                }
            }
        }
    }


