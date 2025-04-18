package com.socialnetwork.bookpediasn.ui.welcome

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class WelcomeViewModel : ViewModel() {
    private val _navigateToLogin = MutableStateFlow(false)
    val navigateToLogin: StateFlow<Boolean> = _navigateToLogin

    private val _navigateToSignup = MutableStateFlow(false)
    val navigateToSignup: StateFlow<Boolean> = _navigateToSignup

    fun onLoginClicked() {
        _navigateToLogin.value = true
    }

    fun onSignUpClicked() {
        _navigateToSignup.value = true
    }

    fun onNavigationDone() {
        _navigateToLogin.value = false
        _navigateToSignup.value = false
    }
}
