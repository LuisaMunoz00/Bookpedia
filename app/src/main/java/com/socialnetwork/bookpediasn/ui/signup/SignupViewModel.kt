package com.socialnetwork.bookpediasn.ui.signup

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SignupViewModel : ViewModel() {
    private val _navigateToLogin = MutableStateFlow(false)
    val navigateToLogin: StateFlow<Boolean> = _navigateToLogin

   // private val _navigateToSignup = MutableStateFlow(false)
   // val navigateToLogin: StateFlow<Boolean> = _navigateToSignup

    fun onSignupButtonClicked() {
        _navigateToLogin.value = true
    }

    fun onLoginClicked() {
        _navigateToLogin.value = true
    }

    fun onNavigationDone() {
        _navigateToLogin.value = false
        //_navigateToSignup.value = false
    }
}