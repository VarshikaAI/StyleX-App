package com.stylex.app.data

import android.content.Context
import android.content.SharedPreferences

class UserRepository(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("StyleXPrefs", Context.MODE_PRIVATE)

    // Save user data during sign up
    fun saveUser(
        email: String,
        password: String,
        gender: String,
        age: Int,
        skinTone: String,
        bodyShape: String
    ): Boolean {
        return try {
            prefs.edit().apply {
                putString("user_$email", password)
                putString("gender_$email", gender)
                putInt("age_$email", age)
                putString("skinTone_$email", skinTone)
                putString("bodyShape_$email", bodyShape)
                putString("current_user", email)
                apply()
            }
            true
        } catch (e: Exception) {
            false
        }
    }

    // Check login credentials
    fun login(email: String, password: String): Boolean {
        val savedPassword = prefs.getString("user_$email", null)
        return if (savedPassword == password) {
            prefs.edit().putString("current_user", email).apply()
            true
        } else {
            false
        }
    }

    // Check if user exists
    fun userExists(email: String): Boolean {
        return prefs.contains("user_$email")
    }

    // Get current user info
    fun getCurrentUser(): UserData? {
        val email = prefs.getString("current_user", null) ?: return null
        val gender = prefs.getString("gender_$email", "Male") ?: "Male"
        val age = prefs.getInt("age_$email", 25)
        val skinTone = prefs.getString("skinTone_$email", "Medium") ?: "Medium"
        val bodyShape = prefs.getString("bodyShape_$email", "Rectangle") ?: "Rectangle"
        return UserData(email, gender, age, skinTone, bodyShape)
    }

    // Logout
    fun logout() {
        prefs.edit().remove("current_user").apply()
    }
}

data class UserData(
    val email: String,
    val gender: String,
    val age: Int,
    val skinTone: String,
    val bodyShape: String
)