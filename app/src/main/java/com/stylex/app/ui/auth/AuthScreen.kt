package com.stylex.app.ui.auth

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stylex.app.ui.theme.*

@Composable
fun AuthScreen(onAuthSuccess: () -> Unit) {
    val context = LocalContext.current
    val viewModel = remember { AuthViewModel(context) }
    val authState by viewModel.authState.collectAsState()

    var isLogin by remember { mutableStateOf(true) }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("Male") }
    var age by remember { mutableStateOf("") }
    var skinTone by remember { mutableStateOf("Medium") }
    var bodyShape by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    // Handle auth success
    LaunchedEffect(authState) {
        if (authState is AuthState.Success) {
            onAuthSuccess()
            viewModel.resetState()
        }
    }

    // Set default body shape based on gender
    LaunchedEffect(gender) {
        if (!isLogin) {
            bodyShape = if (gender == "Male") "Rectangle" else "Hourglass"
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFDF4FF),
                        Color(0xFFF3E8FF),
                        Color(0xFFE9D5FF)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            // App Logo/Title
            Text(
                text = "StyleX",
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                color = PrimaryPurple
            )
            Text(
                text = "Your Outfit Companion",
                fontSize = 16.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Auth Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                elevation = CardDefaults.cardElevation(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Toggle Tabs
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Button(
                            onClick = { isLogin = true },
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (isLogin) PrimaryPurple else Color.LightGray
                            ),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text("Login")
                        }

                        Button(
                            onClick = { isLogin = false },
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (!isLogin) PrimaryPink else Color.LightGray
                            ),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text("Sign Up")
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // Email Field
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email") },
                        leadingIcon = { Icon(Icons.Default.Email, null) },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Password Field
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        leadingIcon = { Icon(Icons.Default.Lock, null) },
                        trailingIcon = {
                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(
                                    if (passwordVisible) Icons.Default.Visibility
                                    else Icons.Default.VisibilityOff,
                                    contentDescription = null
                                )
                            }
                        },
                        visualTransformation = if (passwordVisible)
                            VisualTransformation.None
                        else
                            PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        shape = RoundedCornerShape(12.dp)
                    )

                    // Sign Up Extra Fields
                    AnimatedVisibility(visible = !isLogin) {
                        Column {
                            Spacer(modifier = Modifier.height(16.dp))

                            // Gender Selection
                            Text("Gender", fontWeight = FontWeight.Medium)
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                FilterChip(
                                    selected = gender == "Male",
                                    onClick = { gender = "Male" },
                                    label = { Text("Male") },
                                    modifier = Modifier.weight(1f)
                                )
                                FilterChip(
                                    selected = gender == "Female",
                                    onClick = { gender = "Female" },
                                    label = { Text("Female") },
                                    modifier = Modifier.weight(1f)
                                )
                            }

                            Spacer(modifier = Modifier.height(16.dp))

                            // Age Field
                            OutlinedTextField(
                                value = age,
                                onValueChange = { age = it },
                                label = { Text("Age") },
                                leadingIcon = { Icon(Icons.Default.Person, null) },
                                modifier = Modifier.fillMaxWidth(),
                                singleLine = true,
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                shape = RoundedCornerShape(12.dp)
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            // Skin Tone Selection
                            Text("Skin Tone", fontWeight = FontWeight.Medium)
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                SkinToneOption(
                                    color = SkinToneFair,
                                    label = "Fair",
                                    selected = skinTone == "Fair",
                                    onClick = { skinTone = "Fair" }
                                )
                                SkinToneOption(
                                    color = SkinToneMedium,
                                    label = "Medium",
                                    selected = skinTone == "Medium",
                                    onClick = { skinTone = "Medium" }
                                )
                                SkinToneOption(
                                    color = SkinToneDark,
                                    label = "Dark",
                                    selected = skinTone == "Dark",
                                    onClick = { skinTone = "Dark" }
                                )
                            }

                            Spacer(modifier = Modifier.height(16.dp))

                            // Body Shape Selection
                            Text("Body Shape", fontWeight = FontWeight.Medium)
                            Spacer(modifier = Modifier.height(8.dp))

                            if (gender == "Female") {
                                Column(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        BodyShapeChip(
                                            shape = "Hourglass",
                                            emoji = "⏳",
                                            selected = bodyShape == "Hourglass",
                                            onClick = { bodyShape = "Hourglass" },
                                            modifier = Modifier.weight(1f)
                                        )
                                        BodyShapeChip(
                                            shape = "Pear",
                                            emoji = "🍐",
                                            selected = bodyShape == "Pear",
                                            onClick = { bodyShape = "Pear" },
                                            modifier = Modifier.weight(1f)
                                        )
                                    }
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        BodyShapeChip(
                                            shape = "Apple",
                                            emoji = "🍎",
                                            selected = bodyShape == "Apple",
                                            onClick = { bodyShape = "Apple" },
                                            modifier = Modifier.weight(1f)
                                        )
                                        BodyShapeChip(
                                            shape = "Rectangle",
                                            emoji = "📏",
                                            selected = bodyShape == "Rectangle",
                                            onClick = { bodyShape = "Rectangle" },
                                            modifier = Modifier.weight(1f)
                                        )
                                    }
                                    BodyShapeChip(
                                        shape = "Inverted Triangle",
                                        emoji = "🔺",
                                        selected = bodyShape == "Inverted Triangle",
                                        onClick = { bodyShape = "Inverted Triangle" },
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                }
                            } else {
                                Column(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        BodyShapeChip(
                                            shape = "Triangle",
                                            emoji = "🔻",
                                            selected = bodyShape == "Triangle",
                                            onClick = { bodyShape = "Triangle" },
                                            modifier = Modifier.weight(1f)
                                        )
                                        BodyShapeChip(
                                            shape = "Inverted Triangle",
                                            emoji = "🔺",
                                            selected = bodyShape == "Inverted Triangle",
                                            onClick = { bodyShape = "Inverted Triangle" },
                                            modifier = Modifier.weight(1f)
                                        )
                                    }
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        BodyShapeChip(
                                            shape = "Rectangle",
                                            emoji = "📏",
                                            selected = bodyShape == "Rectangle",
                                            onClick = { bodyShape = "Rectangle" },
                                            modifier = Modifier.weight(1f)
                                        )
                                        BodyShapeChip(
                                            shape = "Trapezoid",
                                            emoji = "💪",
                                            selected = bodyShape == "Trapezoid",
                                            onClick = { bodyShape = "Trapezoid" },
                                            modifier = Modifier.weight(1f)
                                        )
                                    }
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // Error Message
                    if (authState is AuthState.Error) {
                        Text(
                            text = (authState as AuthState.Error).message,
                            color = MaterialTheme.colorScheme.error,
                            fontSize = 14.sp
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                    }

                    // Submit Button
                    Button(
                        onClick = {
                            if (isLogin) {
                                viewModel.login(email, password)
                            } else {
                                viewModel.signUp(email, password, gender, age, skinTone, bodyShape)
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isLogin) PrimaryPurple else PrimaryPink
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text(
                            text = if (isLogin) "Login" else "Sign Up",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }}
@Composable
fun SkinToneOption(
    color: Color,
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable(onClick = onClick)
    ) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(color)
                .border(
                    width = if (selected) 4.dp else 2.dp,
                    color = if (selected) PrimaryPurple else Color.Gray,
                    shape = CircleShape
                )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = label,
            fontSize = 12.sp,
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal,
            color = if (selected) PrimaryPurple else Color.Gray
        )
    }
}
@Composable
fun BodyShapeChip(
    shape: String,
    emoji: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .height(60.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (selected) PrimaryPurple.copy(alpha = 0.1f) else Color.White
        ),
        border = if (selected) {
            CardDefaults.outlinedCardBorder().copy(
                brush = Brush.linearGradient(listOf(PrimaryPurple, PrimaryPink)),
                width = 2.dp
            )
        } else {
            CardDefaults.outlinedCardBorder()
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = emoji,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = shape,
                fontSize = 14.sp,
                fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal,
                color = if (selected) PrimaryPurple else Color.DarkGray,
                textAlign = TextAlign.Center
            )
        }
    }
}