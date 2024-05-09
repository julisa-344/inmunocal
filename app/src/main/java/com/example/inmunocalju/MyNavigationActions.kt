package com.example.inmunocalju

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

class MyNavigationActions(private val navController: NavController) {
    fun navigateTo(destination: MyTopLevelDestination) {
        navController.navigate(destination.route){
            popUpTo(navController.graph.findStartDestination().id){
                saveState = true
            }
            launchSingleTop = true
        }
    }
}

data class MyTopLevelDestination(
    val route: String,
    val selectedIcon: ImageVector,
    val iconTextId: Int,
)

val TOP_LEVEL_DESTINATION = listOf(
    MyTopLevelDestination(
        route = MyRoute.HOME,
        selectedIcon = Icons.Default.Home,
        iconTextId = R.string.home
    ),
    MyTopLevelDestination(
        route = MyRoute.TESTIMONIO,
        selectedIcon = Icons.Default.MailOutline,
        iconTextId = R.string.testimonio
    ),
    MyTopLevelDestination(
        route = MyRoute.CART,
        selectedIcon = Icons.Default.ShoppingCart,
        iconTextId = R.string.cart
    ),
    MyTopLevelDestination(
        route = MyRoute.PROFILE,
        selectedIcon = Icons.Default.AccountCircle,
        iconTextId = R.string.profile
    ),
)

object MyRoute{
    const val HOME = "home"
    const val TESTIMONIO = "testimonio"
    const val CART = "cart"
    const val PROFILE = "profile"
}