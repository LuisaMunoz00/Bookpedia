package com.socialnetwork.bookpediasn.ui.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.socialnetwork.bookpediasn.R

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    welcomeViewModel: WelcomeViewModel = viewModel()
) {
    val navigateToLogin by welcomeViewModel.navigateToLogin.collectAsState()
    val navigateToSignUp by welcomeViewModel.navigateToSignup.collectAsState()

    LaunchedEffect(navigateToLogin, navigateToSignUp) {
        when {
            navigateToLogin -> {
                navController.navigate("login")
                welcomeViewModel.onNavigationDone()
            }

            navigateToSignUp -> {
                navController.navigate("signup")
                welcomeViewModel.onNavigationDone()
            }
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_welcome),
            contentDescription = "background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.linearGradient(
                        0.0f to Color(alpha = 41, red = 121, green = 83, blue = 42),
                        0.85f to Color(alpha = 204, red = 0, green = 0, blue = 0),
                        start = Offset(0.5f, -0.16f),
                        end = Offset(0.5f, Float.POSITIVE_INFINITY)
                    )
                )
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Spacer(modifier = Modifier.height(85.dp))

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .aspectRatio(1f)
            )

            Spacer(modifier = Modifier.height(120.dp))

            Button(
                onClick = { welcomeViewModel.onLoginClicked() },
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .height(58.dp)
                    .clip(RoundedCornerShape(40.dp)),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xffb98042))
            ) {
                Text(
                    text = "LOG IN",
                    color = Color.White,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            val annotatedText = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.White,
                        fontSize = 15.sp
                    )
                ) {
                    append("Don’t have an account? ")
                }

                // Anotamos "Sign Up" con una etiqueta
                pushStringAnnotation(tag = "SIGN_UP", annotation = "sign_up")
                withStyle(
                    style = SpanStyle(
                        color = Color(0xffb98042),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline
                    )
                ) {
                    append("Sign Up")
                }
                pop()
            }

            ClickableText(
                text = annotatedText,
                onClick = { offset ->
                    annotatedText.getStringAnnotations(tag = "SIGN_UP", start = offset, end = offset)
                        .firstOrNull()?.let {
                            welcomeViewModel.onSignUpClicked()
                        }
                }
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(navController = rememberNavController())
}
