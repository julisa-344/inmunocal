package com.example.inmunocalju.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.inmunocalju.R

@Composable
fun Payment1(navController: NavController){

    val numeroTarjeta = remember { mutableStateOf("") }
    var fechaExp = remember { mutableStateOf("") }
    var cvv = remember { mutableStateOf("") }

    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column (modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.primary_600)),
            verticalArrangement = Arrangement.Top
        ){
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(Color.Cyan),
                verticalAlignment = Alignment.CenterVertically
            ){
                Row(
                ){
                    Column(modifier = Modifier
                        .width(15.dp)
                    ){
                    }
                    Button(onClick = {},
                        modifier = Modifier
                            .size(50.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray.copy(alpha=0.5f)),
                        shape = CircleShape,
                        contentPadding = PaddingValues(0.dp)
                    ){
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = null,
                            modifier = Modifier
                        )
                    }
                    Text("Pagos",
                        modifier = Modifier
                            .padding(10.dp),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                    )
                }
            }

            Box(modifier = Modifier
                .size(width = 395.dp, height = 300.dp),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(R.drawable.tajeta),
                    contentDescription = "Descripción de la imagen",
                    modifier = Modifier
                        .size(width = 325.dp, height = 200.dp)
                )
            }
            Column(modifier = Modifier
                .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text("Ingrese los datos de su tarjeta",
                    fontWeight = FontWeight.Bold
                )
                OutlinedTextField(
                    value = numeroTarjeta,
                    onValueChange = { nuevoNumero ->
                        numeroTarjeta = nuevoNumero
                    },
                    label = { Text("Número de tarjeta") },
                    singleLine = true,
                    modifier = Modifier
                        .width(300.dp)
                )
                Row(){
                    OutlinedTextField(
                        value = fechaExp,
                        onValueChange = {
                        },
                        label = { "MM/YY" },
                        singleLine = true,
                        modifier = Modifier
                            .width(145.dp)
                    )
                    Spacer(modifier = Modifier
                        .width(10.dp)
                    )

                    OutlinedTextField(
                        value = cvv,
                        onValueChange = {
                        },
                        label = { "CVV" },
                        singleLine = true,
                        modifier = Modifier
                            .width(145.dp)
                    )

                }
                Spacer(modifier = Modifier
                    .height(20.dp)
                )
                Button(modifier = Modifier
                    .size(width = 300.dp, height = 55.dp),
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(Color.Green),
                    onClick = {

                    }
                ) {
                    Text("Procesar Pago",
                        modifier = Modifier,
                        color = Color.White)
                }

                Spacer(modifier = Modifier
                    .height(20.dp)
                )

                Row(){
                    OutlinedButton(modifier = Modifier
                        .size(width = 120.dp, height = 45.dp),
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(Color.Gray.copy(alpha = 0.5f)),
                        onClick = {

                        }
                    ) {
                        Text("Limpiar",
                            modifier = Modifier,
                            color = Color.White)
                    }

                    Spacer(modifier = Modifier
                        .width(10.dp)
                    )

                    OutlinedButton(modifier = Modifier
                        .size(width = 120.dp, height = 45.dp),
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(Color.Red.copy(alpha = 0.5f)),
                        onClick = {

                        }
                    ) {
                        Text("Cancelar",
                            modifier = Modifier,
                            color = Color.White)
                    }
                }

                Spacer(modifier = Modifier
                    .height(130.dp)
                )

                Row(verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null,
                        modifier = Modifier
                    )

                    Text("Secured by")
                    Text(" PayStack",
                        fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}