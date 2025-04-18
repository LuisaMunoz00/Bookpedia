package com.socialnetwork.bookpediasn.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.navigation.NavController
import androidx.navigation.compose.*
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.socialnetwork.bookpediasn.ui.login.LoginScreen
import com.socialnetwork.bookpediasn.ui.login.ForgotPasswordScreen
import com.socialnetwork.bookpediasn.ui.signup.SignupScreen
import com.socialnetwork.bookpediasn.ui.welcome.WelcomeScreen
import androidx.compose.runtime.getValue


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "welcome") {
        composable("welcome") { WelcomeScreen(navController = navController) }
        composable("login") { LoginScreen(navController = navController) }
        composable("signup") { SignupScreen(navController = navController) }
        composable("forgot_password") { ForgotPasswordScreen()}
    }
}