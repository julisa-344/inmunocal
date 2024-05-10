package com.example.inmunocalju

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.inmunocalju.ui.theme.InmunocaljuTheme
import com.example.inmunocalju.views.Categoria
import com.example.inmunocalju.views.Producto
import com.example.inmunocalju.views.UserProfile
import com.example.inmunocalju.views.cart_view
import com.example.inmunocalju.views.detail_perfil_view
import com.example.inmunocalju.views.home_view
import com.example.inmunocalju.views.products_view
import com.example.inmunocalju.views.profile_view
import com.example.inmunocalju.views.testimonio_view
import com.example.suscripciones.views.actual_sub_view
import com.example.suscripciones.views.detail_sub_view
import com.example.suscripciones.views.promos_view
import com.example.suscripciones.views.suscripcion_view

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InmunocaljuTheme {
                // A surface container using the 'background' color from the theme
                Surface {
                    val navController = rememberNavController()
                    val navigationActions = remember(navController){
                        MyNavigationActions(navController)
                    }
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val selectedDestination = navBackStackEntry?.destination?.route ?: MyRoute.HOME
                    MyAppContent(
                        navController = navController,
                        selectedDestination = selectedDestination,
                        navigateTopLevelDestination = navigationActions::navigateTo
                    )
                }
            }
        }
    }
}

@Composable
fun BottomNavigation(
    selectedDestination: String,
    navigateTopLevelDestination: ( MyTopLevelDestination ) -> Unit,
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
        .background(
            colorResource(id = R.color.primary_600),
            RoundedCornerShape(topStart = 20.dp, topEnd = 30.dp)
        )){
        NavigationBar(modifier = Modifier
        ) {
            TOP_LEVEL_DESTINATION.forEach() { destinations ->
                NavigationBarItem(
                    selected = selectedDestination == destinations.route,
                    onClick = { navigateTopLevelDestination(destinations) },
                    icon = {
                        Icon(
                            imageVector = destinations.selectedIcon,
                            contentDescription = stringResource(id = destinations.iconTextId),
                            tint = colorResource(id = R.color.neutral_500)
                        )
                    }
                )
            }
        }
    }
}


@Composable
fun MyAppContent(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    selectedDestination: String,
    navigateTopLevelDestination: (MyTopLevelDestination) -> Unit
) {
    Row(modifier = modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            NavHost(
                modifier = Modifier.weight(1f),
                navController = navController,
                startDestination = MyRoute.HOME
            ) {
                composable(MyRoute.HOME) {
                    home_view(navController)
                }
                composable(MyRoute.TESTIMONIO) {
                    suscripcion_view(navController)
                }
                composable(MyRoute.CART) {
                    cart_view()
                }
                composable(MyRoute.PROFILE) {
                    profile_view()
                }

                composable("detail_sub") { detail_sub_view(navController) }
                composable("promos") { promos_view(navController) }
                composable("detail_perfil") {

                    val userProfile = UserProfile(
                        name = "John Doe",
                        email = "john.doe@gmail.com",
                        subscription = "Premium",
                        gender = "Hombre",
                        birthday = "1985-10-15",
                        phoneNumber = "937 601 484"
                    )
                    detail_perfil_view(userProfile, navController)
                }
                composable("actual_sub") { actual_sub_view(navController) }
                composable("products") {
                    val categorias = listOf(
                        Categoria("Salud", "url_imagen_1"),
                        Categoria("Nutricion", "url_imagen_2"),
                        Categoria("Deporte", "url_imagen_2"),
                        Categoria("Suplemento", "url_imagen_2")
                    )
                    val productos = listOf(
                        Producto("Immunocal", "url_imagen_1"),
                        Producto("Knutric +", "url_imagen_2")
                    )
                    val cantidadEnCarrito = remember { mutableStateOf(0) }

                    products_view(
                        categorias = categorias,
                        productos = productos,
                        cantidadEnCarrito = cantidadEnCarrito.value,
                        onRegresarClicked = { /* TODO */ },
                        onCarritoClicked = { /* TODO */ },
                        onAgregarAlCarrito = { producto ->
                            cantidadEnCarrito.value++
                        }
                    )
                }


            }
            BottomNavigation(
                selectedDestination = selectedDestination,
                navigateTopLevelDestination = navigateTopLevelDestination,
            )
        }
    }
}
