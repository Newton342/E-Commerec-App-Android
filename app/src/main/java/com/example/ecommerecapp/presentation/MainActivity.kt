package com.example.ecommerecapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.ecommerecapp.presentation.navigation.AppNavController
import com.example.ecommerecapp.presentation.ui.theme.ECommerecAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ECommerecAppTheme {
                AppNavController()
            }
        }
    }
}

