package com.stylex.app.ui.auth

import android.content.Context
import androidx.lifecycle.ViewModel
import com.stylex.app.data.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthViewModel(context: Context) : ViewModel() {
    private val userRepository = UserRepository(context)

    private val _authState = MutableStateFlow<AuthState>(AuthState.Idle)
    val authState: StateFlow<AuthState> = _authState.asStateFlow()

    fun signUp(
        email: String,
        password: String,
        gender: String,
        age: String,
        skinTone: String,
        bodyShape: String
    ) {
        // Validation
        if (email.isEmpty() || password.isEmpty() || gender.isEmpty() ||
            age.isEmpty() || skinTone.isEmpty() || bodyShape.isEmpty()) {
            _authState.value = AuthState.Error("All fields are required")
            return
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _authState.value = AuthState.Error("Invalid email format")
            return
        }

        if (password.length < 6) {
            _authState.value = AuthState.Error("Password must be at least 6 characters")
            return
        }

        val ageInt = age.toIntOrNull()
        if (ageInt == null || ageInt < 13 || ageInt > 100) {
            _authState.value = AuthState.Error("Please enter a valid age (13-100)")
            return
        }

        // Check if user exists
        if (userRepository.userExists(email)) {
            _authState.value = AuthState.Error("User already exists. Please login.")
            return
        }

        // Save user
        val success = userRepository.saveUser(email, password, gender, ageInt, skinTone, bodyShape)
        _authState.value = if (success) {
            AuthState.Success
        } else {
            AuthState.Error("Sign up failed. Please try again.")
        }
    }

    fun login(email: String, password: String) {
        // Validation
        if (email.isEmpty() || password.isEmpty()) {
            _authState.value = AuthState.Error("Email and password are required")
            return
        }

        // Check login
        val success = userRepository.login(email, password)
        _authState.value = if (success) {
            AuthState.Success
        } else {
            AuthState.Error("Invalid email or password")
        }
    }

    fun resetState() {
        _authState.value = AuthState.Idle
    }
}

sealed class AuthState {
    object Idle : AuthState()
    object Success : AuthState()
    data class Error(val message: String) : AuthState()
}