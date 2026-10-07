package com.upchiapas.propinas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.upchiapas.propinas.screen.PropinaScreen
import com.upchiapas.propinas.ui.theme.PropinasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PropinasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PropinaScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}