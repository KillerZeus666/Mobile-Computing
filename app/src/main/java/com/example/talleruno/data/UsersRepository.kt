package com.example.talleruno.data


import com.example.talleruno.data.model.User
import com.example.talleruno.data.remote.ApiClient


class UsersRepository(private val api: ApiClient = ApiClient()) {
    private var cache: List<User>? = null


    suspend fun getUsers(): List<User> {
        if (cache == null) cache = api.fetchUsers()
        return cache!!
    }


    fun getUserById(id: Int): User? = cache?.firstOrNull { it.id == id }
}