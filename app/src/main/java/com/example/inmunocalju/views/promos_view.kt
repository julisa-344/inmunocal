package com.example.suscripciones.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.inmunocalju.R

@Composable
fun promos_view(navController: NavHostController) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabTitles = listOf("Habilitados", "Expirados")
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)){
        Column {
            Row(modifier = Modifier
                .fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                        .padding(0.dp),
                    tint = colorResource(R.color.primary_600)
                )
                Text(
                    text = "AnualFort",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium.copy(color = colorResource(R.color.primary_600))
                )
            }

            Spacer(modifier = Modifier.size(30.dp))

            Column(modifier = Modifier.fillMaxWidth()) {
                // Barra de pestañas
                TabRow(
                    selectedTabIndex = selectedTabIndex,
                    Modifier.background(colorResource(R.color.primary_600)),
                    contentColor = colorResource(R.color.primary_600)
                ) {
                    tabTitles.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTabIndex == index,
                            onClick = { selectedTabIndex = index },
                            text = { Text(title) },
                            selectedContentColor =  colorResource(R.color.primary_600),
                            unselectedContentColor =  colorResource(R.color.neutral_400)
                        )
                    }
                }
                when (selectedTabIndex) {
                    0 -> HabilitadosView(navController)
                    1 -> ExpiradosView()
                }
            }
        }
    }
}

@Composable
fun CouponCard(navController: NavHostController) {
    Spacer(modifier = Modifier.size(20.dp))
    Row(
        modifier = Modifier
            .background(colorResource(R.color.primary_500), RoundedCornerShape(8.dp))
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.discount),
            contentDescription = "Discount Logo",
            modifier = Modifier
                .weight(1f)
                .height(50.dp)
                .size(100.dp)
        )
        Column(
            modifier = Modifier
                .weight(2f)
                .padding(start = 16.dp)
        ) {
            Text("10% OFF", style = MaterialTheme.typography.titleMedium, color = colorResource(id = R.color.neutral_600))
            Text("Código: ahhshxd", fontSize = 16.sp, color = Color.Gray)
            Spacer(modifier = Modifier.size(2.dp))
            Button(
                onClick = { navController.navigate("detail_perfil") },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.secondary_600)),
                modifier = Modifier.width(150.dp)
            ) {
                Text("Usa tu cupón",
                    style = MaterialTheme.typography.labelSmall,
                    color = colorResource(R.color.neutral_600)
                )
            }
        }
    }
}

@Composable
fun HabilitadosView(navController: NavHostController) {
    Spacer(modifier = Modifier.size(20.dp))
    Column {
        Row(
            modifier = Modifier
                .background(colorResource(R.color.neutral_300), RoundedCornerShape(8.dp))
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "Discount Icon",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            BasicTextField(
                value = "",
                onValueChange = {},
                singleLine = true,
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp),
                textStyle = androidx.compose.ui.text.TextStyle(fontSize = 18.sp),
            )
            Spacer(modifier = Modifier.width(8.dp))
            IconButton(onClick = { /* TODO: Agregar acción para nuevo cupón */ }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Coupon"
                )
            }
        }
        Spacer(modifier = Modifier.size(20.dp))
        CouponCard(navController)
        CouponCard(navController)
        CouponCard(navController)
    }
}

@Composable
fun ExpiradosView() {
    // Contenido para promociones expiradas
    Text("Promociones Expiradas")
}
