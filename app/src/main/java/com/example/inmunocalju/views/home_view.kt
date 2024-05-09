package com.example.inmunocalju.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun home_view() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "Home view")
    }
}