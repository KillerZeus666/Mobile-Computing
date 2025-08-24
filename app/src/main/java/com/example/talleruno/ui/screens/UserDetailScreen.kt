package com.example.talleruno.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.talleruno.data.model.User

@Composable
fun UserDetailScreen(user: User) {
    Text("Detalle de ${user.firstName} ${user.lastName}")
}
