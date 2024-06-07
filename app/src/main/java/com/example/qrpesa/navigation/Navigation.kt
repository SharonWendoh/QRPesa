package com.example.qrpesa.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.qrpesa.pages.PinPage
import com.example.qrpesa.pages.QRPesaLogin
import com.example.qrpesa.pages.SuccessfulTransactionPage

@Composable
fun Navigation(
    tillNumber: String?,
    amount: String?,
){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Screen.Login.route
    ){
        composable(route = Screen.Screen.Login.route){
            QRPesaLogin(navController = navController)
        }
        composable(route = Screen.Screen.Pin.route){
            PinPage(tillNumber = tillNumber, amount = amount, navController = navController)
        }
        composable(route = Screen.Screen.SuccessfulTransaction.route){
            SuccessfulTransactionPage(tillNumber = tillNumber, amount = amount)
        }
    }
}