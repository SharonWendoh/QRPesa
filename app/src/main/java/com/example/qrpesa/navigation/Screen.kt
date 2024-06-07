package com.example.qrpesa.navigation

class Screen {
    sealed class Screen(val route: String){
        object Login : Screen("login_screen")
        object Pin : Screen("pin_screen")
        object SuccessfulTransaction : Screen("successful_transaction_screen")
    }
}