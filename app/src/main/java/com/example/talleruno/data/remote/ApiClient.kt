package com.example.talleruno.data.remote

import com.example.talleruno.data.model.UsersResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

//Clase que realiza la petición http a la API con la lista de Usuarios
class ApiClient {
    private val client = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
        install(Logging) { level = LogLevel.BODY }
    }

    suspend fun fetchUsers() =
        client.get("https://dummyjson.com/users").body<UsersResponse>().users
}
