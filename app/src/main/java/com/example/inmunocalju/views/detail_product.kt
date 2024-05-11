package com.example.inmunocalju.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.navigation.NavHostController
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.inmunocalju.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductosView(navController: NavHostController){

    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Column(modifier = Modifier) {
            Box (modifier = Modifier) {
                Image(painter = painterResource(id = R.drawable.immunocal_sport_2), contentDescription = null)

                IconButton(onClick = { navController.navigate("lista") },
                    modifier = Modifier
                        //.padding(16.dp)
                        .align(Alignment.TopStart)) {
                    Icon(imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Retroceso",
                        tint = Color.White)
                }

                IconButton(onClick = { navController.navigate("lista") },
                    modifier = Modifier
                        //.padding(16.dp)
                        .align(Alignment.TopEnd)) {
                    Icon(imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Retroceso",
                        tint = Color.White)
                }

            }
            Column (modifier = Modifier.padding(15.dp)) {
                Text(text = "Immunocal Sport",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
                )
                Row {
                    Text(text = " S/. 374.25",
                        style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Bold),
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = " S/. 499.00",
                        style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color.Gray),
                        textDecoration = TextDecoration.LineThrough
                    )
                }
            }
            val pageState = rememberPagerState(
                pageCount = {2}
            )
            val coroutineScope = rememberCoroutineScope()


            TabRow(selectedTabIndex = pageState.currentPage) {
                Tab(text = { Text(text = "Descripcion")},
                    selected = pageState.currentPage == 0,
                    onClick = {
                        coroutineScope.launch {
                            pageState.animateScrollToPage(0)
                        }
                    })
                Tab(text = { Text(text = "Datos Nutricionales")},
                    selected = pageState.currentPage == 1,
                    onClick = {
                        coroutineScope.launch {
                            pageState.animateScrollToPage(1)
                        }
                    })
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(color = Color.White)
            ) {
                // Contenido de la pestaña seleccionada
                when (pageState.currentPage) {
                    0 -> {Text("Immunocal Sport está diseñado para mejorar el rendimiento y recuperación de los deportistas, desde principiantes hasta olímpicos.",
                        modifier = Modifier.padding(15.dp))}
                    1 -> {Text("Immunocal Sport es el nuevo suplemento de Immunotec que contiene ingredientes activos como Immunocal, Nitro Boost, raíz de remolacha y cereza ácida. ",
                        modifier = Modifier.padding(15.dp))}
                    else -> {Text(text = "No reconocido")}
                    // Agrega más casos según sea necesario
                }
            }
            Box(modifier = Modifier.padding(15.dp)){
                Text(text = "Productos Relacionados",
                    style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Bold))
            }
            Row(modifier = Modifier.padding(15.dp))  {
                Row (modifier = Modifier, verticalAlignment = Alignment.CenterVertically){

                    Image(painter = painterResource(id = R.drawable.immunocal_optimizer),
                        contentDescription = null,
                        modifier = Modifier.size(80.dp))
                    Column {
                        Text(text = "Optimizer",
                            style = TextStyle(fontSize = 13.sp, fontWeight = FontWeight.SemiBold))
                        Text(text = "S/. 209.25",
                            style = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.SemiBold))
                    }

                }
                Spacer(modifier = Modifier.width(30.dp))
                Row (modifier = Modifier, verticalAlignment = Alignment.CenterVertically){
                    Image(painter = painterResource(id = R.drawable.immunocal_energizer)
                        , contentDescription = null
                        ,modifier = Modifier.size(80.dp))
                    Column {
                        Text(text = "Performance",
                            style = TextStyle(fontSize = 13.sp, fontWeight = FontWeight.SemiBold))
                        Text(text = "S/. 127.50",
                            style = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.SemiBold))
                    }
                }
            }


        }



    }
}