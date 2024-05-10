package com.example.inmunocalju.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import com.example.inmunocalju.R

@Composable
fun home_view(navController: NavController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.primary_600))) {
        Text(text = "Home view")
    }
}