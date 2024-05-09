package com.example.inmunocalju.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.inmunocalju.R

data class UserProfile(
    val name: String,
    val email: String,
    val subscription: String,
    val gender: String,
    val birthday: String,
    val phoneNumber: String
)

@Composable
fun detail_perfil_view(userProfile: UserProfile, navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.neutral_200))
    ) {
        Box(modifier = Modifier
            .background(
                color = colorResource(id = R.color.primary_600),
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomEnd = 16.dp,
                    bottomStart = 16.dp
                )
            )
            .fillMaxWidth()
            .height(100.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.size(20.dp))

            // Agrega aquí el resto de tu UI como la imagen de perfil, etc.
            Row(modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                        .padding(0.dp),
                    tint = colorResource(R.color.neutral_50)
                )
                Text(
                    text = "Mi plan",
                    style = MaterialTheme.typography.titleMedium.copy(color = colorResource(R.color.neutral_50)),
                    textAlign = TextAlign.Center
                )
                Image(
                    painter = painterResource(id = R.drawable.perfil),
                    contentDescription = null,
                    Modifier.size(45.dp))

            }
            Spacer(modifier = Modifier.size(50.dp))
            ProfileDetailItem(title = "Suscripción", value = userProfile.subscription)
            ProfileDetailItem(title = "Nombre", value = userProfile.name)
            ProfileDetailItem(title = "Email", value = userProfile.email)
            ProfileDetailItem(title = "Género", value = userProfile.gender)
            ProfileDetailItem(title = "Cumpleaños", value = userProfile.birthday)
            ProfileDetailItem(title = "Número", value = userProfile.phoneNumber)
        }
    }
}

@Composable
fun ProfileDetailItem(title: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .background(color = colorResource(R.color.neutral_100)),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = value,
            color = colorResource(id = R.color.neutral_500),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(16.dp)
        )
    }
}