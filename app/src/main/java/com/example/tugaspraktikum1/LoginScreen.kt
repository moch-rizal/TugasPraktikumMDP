package com.example.tugaspraktikum1

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Login", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                // navigasi ke homescreen
                navController.navigate("home") {
                    // pengguna tidak dapat kembali ke layar login
                    popUpTo("login") { inclusive = true }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = username.isNotBlank() && password.isNotBlank()
        ) {
            Text("Login")
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(
            onClick = {
                navController.navigate("register")
            }
        ) {
            Text("Tidak Punya Akun? Register Disini.")
        }
    }
}