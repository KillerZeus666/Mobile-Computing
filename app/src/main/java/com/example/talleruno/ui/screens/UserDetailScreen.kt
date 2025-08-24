package com.example.talleruno.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.talleruno.data.model.User


@Composable
fun UserDetailScreen(user: User) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.Start // 👈 mantiene el texto a la izquierda
        ) {
            // Imagen centrada arriba
            androidx.compose.foundation.layout.Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = androidx.compose.foundation.layout.Arrangement.Center
            ) {
                AsyncImage(
                    model = user.image,
                    contentDescription = "Foto de ${user.firstName}",
                    modifier = Modifier
                        .size(120.dp)
                )
            }

            // Nombre destacado
            Text(
                text = "${user.firstName} ${user.lastName}",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Información adicional (alineada a la izquierda)
            Text("Empresa: ${user.company.name}")
            Text("Teléfono: ${user.phone}")
            Text("Email: ${user.email}")
            Text("Edad: ${user.age}")
            Text("Género: ${user.gender}")
            Text("Altura: ${user.height}")
            Text("Peso: ${user.weight}")
            Text("Universidad: ${user.university}")
        }
    }
}
