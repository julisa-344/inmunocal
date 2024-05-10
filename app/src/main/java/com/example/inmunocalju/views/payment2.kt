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
fun Payment2(navController: NavController) {
    var codigo = remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            verticalArrangement = Arrangement.Top
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(Color.Cyan),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                ) {
                    Column(
                        modifier = Modifier
                            .width(15.dp)
                    ) {
                    }
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .size(50.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray.copy(alpha = 0.5f)),
                        shape = CircleShape,
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = null,
                            modifier = Modifier
                        )
                    }
                    Text(
                        "Pagos",
                        modifier = Modifier
                            .padding(10.dp),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                    )
                }
            }

            Spacer(modifier = Modifier
                .height(60.dp))

            Row(modifier = Modifier
                .size(width = 395.dp, height = 250.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ){
                Image(
                    painter = painterResource(R.drawable.bcp),
                    contentDescription = "Descripción de la imagen",
                    modifier = Modifier
                        .size(width = 120.dp, height = 90.dp)
                )
                Image(
                    painter = painterResource(R.drawable.visa),
                    contentDescription = "Descripción de la imagen",
                    modifier = Modifier
                        .size(width = 120.dp, height = 90.dp)
                )
            }

            Column(modifier = Modifier
                .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text("Detalles de la transacción: ")

                Spacer(modifier = Modifier
                    .height(30.dp)
                )

                Row(){
                    Text("Negocio:   ")
                    Text("NaturalHome")
                }
                Row(){
                    Text("Monto total:  ")
                    Text("S/ 100.00")
                }
                Row(){
                    Text("Tarjeta:   ")
                    Text("**** **** **** 1234")
                }
                Row(modifier =Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text("Código:   ")
                    OutlinedTextField(
                        value = codigo,
                        onValueChange = { nuevoNumero ->
                            codigo = codigo
                        },
                        label = { Text("Código") },
                        singleLine = true,
                        modifier = Modifier
                            .size(width = 100.dp, height = 25.dp)
                    )
                }

                Spacer(modifier = Modifier
                    .height(40.dp)
                )

                Column(){
                    OutlinedButton(modifier = Modifier
                        .size(width = 140.dp, height = 45.dp),
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(Color.Gray.copy(alpha = 0.5f)),
                        onClick = {

                        }
                    ) {
                        Text("Nuevo código",
                            modifier = Modifier,
                            color = Color.White)
                    }
                }

                Spacer(modifier = Modifier
                    .height(40.dp)
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

                Spacer(modifier = Modifier
                    .height(110.dp)
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






