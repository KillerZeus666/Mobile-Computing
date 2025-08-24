package com.example.talleruno.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.talleruno.data.UsersRepository
import com.example.talleruno.data.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class UsersUiState(
    val users: List<User> = emptyList(),
    val loading: Boolean = true,
    val error: String? = null
)

class UsersViewModel(
    private val repo: UsersRepository = UsersRepository()
) : ViewModel() {

    private val _state = MutableStateFlow(UsersUiState())
    val state: StateFlow<UsersUiState> = _state

    init {
        refresh()
    }

    fun refresh() {
        viewModelScope.launch {
            try {
                _state.value = UsersUiState(loading = true)
                val users = repo.getUsers()
                _state.value = UsersUiState(users = users, loading = false)
            } catch (e: Exception) {
                _state.value = UsersUiState(error = e.message, loading = false)
            }
        }
    }

    fun userById(id: Int): User? = repo.getUserById(id)
}
