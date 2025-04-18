package com.socialnetwork.bookpediasn.ui.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginViewModel : ViewModel() {
    private val _navigateToHome = MutableStateFlow(false)
    val navigateToHome: StateFlow<Boolean> = _navigateToHome

    private val _navigateToSignUp = MutableStateFlow(false)
    val navigateToSignUp: StateFlow<Boolean> = _navigateToSignUp

    fun onLoginButtonClicked() {
        _navigateToHome.value = true
    }

    fun onSignUpClicked() {
        _navigateToSignUp.value = true
    }

    fun onNavigationDone() {
        _navigateToHome.value = false
        _navigateToSignUp.value = false
    }
}
