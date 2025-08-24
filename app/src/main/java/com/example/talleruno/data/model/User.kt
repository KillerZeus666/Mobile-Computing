package com.example.talleruno.data.model

import kotlinx.serialization.Serializable

@Serializable
data class UsersResponse(
    val users: List<User>
)

@Serializable
data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val image: String,
    val phone: String,
    val company: Company,
    val email: String,
    val age: Int,
    val gender: String,
    val university: String,
    val height: Float,
    val weight: Float,
)

@Serializable
data class Company(
    val name: String,
    val department: String,
    val title: String
)
