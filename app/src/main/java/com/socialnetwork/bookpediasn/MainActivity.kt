package com.socialnetwork.bookpediasn

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.socialnetwork.bookpediasn.navigation.AppNavigation
import com.socialnetwork.bookpediasn.ui.login.LoginScreen
import com.socialnetwork.bookpediasn.ui.theme.BookpediaSNTheme
import com.socialnetwork.bookpediasn.ui.welcome.WelcomeScreen

//class MainActivity : ComponentActivity() {
//    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            BookpediaSNTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) {
//                    LoginScreen()
//                }
//            }
//        }
//    }
//}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewWelcomeScreen() {
    MaterialTheme {
        WelcomeScreen(navController = rememberNavController())
    }
}
