package com.socialnetwork.bookpediasn.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.lifecycle.viewmodel.compose.viewModel
import com.socialnetwork.bookpediasn.R
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    loginViewModel: LoginViewModel = viewModel()
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    val navigateToHome by loginViewModel.navigateToHome.collectAsState()
    val navigateToSignUp by loginViewModel.navigateToSignUp.collectAsState()

    LaunchedEffect(navigateToHome, navigateToSignUp) {
        when {
            navigateToHome -> {
                navController.navigate("home")
                loginViewModel.onNavigationDone()
            }

            navigateToSignUp -> {
                navController.navigate("signup")
                loginViewModel.onNavigationDone()
            }
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFFF1F1F1))
    ) {
        SemiCircleBottomImage(imageRes = R.drawable.bg_welcome)

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            //verticalArrangement = Arrangement.Top
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .height(250.dp)
            )

            Box(
                modifier = Modifier
                    .width(330.dp)
                    .height(503.dp)
                    .clip(RoundedCornerShape(40.dp))
                    .background(Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Button(
                            onClick = { },
                            modifier = Modifier
                                .padding(end = 5.dp)
                                .height(55.dp),
                            shape = RoundedCornerShape(40.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xffb98042))
                        ) {
                            Text(
                                text = "LOG IN",
                                color = Color.White,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(horizontal = 15.dp),
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }

                        Button(
                            onClick = { loginViewModel.onSignUpClicked() },
                            modifier = Modifier
                                .height(55.dp),
                            shape = RoundedCornerShape(40.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.LightGray.copy(
                                    alpha = 0.8f
                                )
                            )
                        ) {
                            Text(
                                text = "SIGN UP",
                                color = Color.White,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(horizontal = 10.dp),
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }
                    } //FIN ROW

                    Spacer(modifier = Modifier.height(50.dp))

                    Text(
                        text = "WELCOME TO BOOKPEDIA",
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    Box {
                        BasicTextField(
                            value = email,
                            onValueChange = { email = it },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                            textStyle = TextStyle(fontSize = 18.sp, color = Color.Black),
                            singleLine = true,
                            modifier = Modifier
                                .align(alignment = Alignment.CenterStart)
                                .fillMaxWidth()
                                .padding(horizontal = 50.dp)
                        )
                        if (email.isEmpty()) {
                            Text(
                                text = "Email",
                                color = Color.LightGray.copy(alpha = 0.8f),
                                style = TextStyle(fontSize = 18.sp),
                                modifier = Modifier
                                    .align(alignment = Alignment.Center)
                            )
                        }
                        Spacer(modifier = Modifier.height(50.dp))

                        HorizontalDivider(
                            color = Color(0xffe5e5e5),
                            modifier = Modifier
                                .align(alignment = Alignment.BottomCenter)
                                .fillMaxWidth()
                                .padding(horizontal = 50.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    Box{
                        BasicTextField(
                            value = password,
                            onValueChange = { password = it },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            textStyle = TextStyle(fontSize = 18.sp, color = Color.Black),
                            singleLine = true,
                            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            modifier = Modifier
                                .align(alignment = Alignment.CenterStart)
                                .fillMaxWidth()
                                .padding(horizontal = 50.dp)
                        )
                        if (password.isEmpty()) {
                            Text(
                                text = "Password",
                                color = Color.LightGray.copy(alpha = 0.8f),
                                style = TextStyle(fontSize = 18.sp),
                                modifier = Modifier
                                    .align(alignment = Alignment.Center)
                            )
                        }
                        IconButton(
                            onClick = { passwordVisible = !passwordVisible },
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                        ) {
                            val icon =
                                if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                            Icon(
                                imageVector = icon,
                                contentDescription = "Toggle Password Visibility"
                            )
                        }

                        HorizontalDivider(
                            color = Color(0xffe5e5e5),
                            modifier = Modifier
                                .align(alignment = Alignment.BottomCenter)
                                .fillMaxWidth()
                                .padding(horizontal = 50.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(50.dp))

                    Box(
                        modifier = Modifier
                            .padding(horizontal = 30.dp)

                    ) {
                        Button(
                            onClick = { loginViewModel.onLoginButtonClicked() },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(55.dp),
                           
                            shape = RoundedCornerShape(40.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xffb98042))
                        ) {
                            Text(
                                text = "LOG IN",
                                color = Color.White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(25.dp))

                    Text(
                        text = "Forgot password?",
                        color = Color(0xffb98042),
                        textDecoration = TextDecoration.Underline,
                        fontSize = 15.sp,
                        modifier = Modifier
                            .clickable {
                                navController.navigate("forgot_password")
                            }
                    )

                }
            }
        }
    }
}

@Composable
fun SemiCircleBottomImage(imageRes: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
            .clip(object : Shape {
                override fun createOutline(
                    size: Size,
                    layoutDirection: LayoutDirection,
                    density: Density
                ): Outline {
                    val path = Path().apply {
                        moveTo(0f, 0f)
                        lineTo(size.width, 0f)
                        lineTo(size.width, size.height * 0.5f)
                        arcTo(
                            rect = Rect(
                                left = -size.width * 0.1f,
                                top = size.height * 0.5f,
                                right = size.width * 1.1f,
                                bottom = size.height
                            ),
                            startAngleDegrees = 0f,
                            sweepAngleDegrees = 180f,
                            forceMoveTo = false
                        )
                        lineTo(0f, size.height * 0.5f)
                        close()
                    }
                    return Outline.Generic(path)
                }
            })
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentScale = ContentScale.FillBounds,
            contentDescription = null,
            modifier = Modifier
                .background(Color.Transparent)
                .drawWithContent {
                    drawContent()
                    drawRect(
                        brush = Brush.linearGradient(
                            0.44f to Color(
                                alpha = 178,
                                red = 121,
                                green = 83,
                                blue = 42
                            ),
                            1.0f to Color(
                                alpha = 178,
                                red = 255,
                                green = 255,
                                blue = 255
                            ),
                            start = Offset(size.width * 0.5f, size.height * 0.41f),
                            end = Offset(size.width * 0.5f, size.height)
                        )
                    )
                }
                .requiredWidth(427.0.dp)
                .requiredHeight(689.0.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(navController = rememberNavController())
}