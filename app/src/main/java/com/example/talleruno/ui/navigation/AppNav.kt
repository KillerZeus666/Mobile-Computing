package com.example.talleruno.ui.navigation


import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.talleruno.ui.UsersViewModel
import com.example.talleruno.ui.screens.UserDetailScreen
import com.example.talleruno.ui.screens.UsersListScreen


sealed class Dest(val route: String) {
    data object List : Dest("list")
    data object Detail : Dest("detail/{userId}") {
        fun create(id: Int) = "detail/$id"
    }
}


@Composable
fun AppNav() {
    val nav = rememberNavController()
    val vm: UsersViewModel = viewModel()
    val uiState = vm.state.collectAsState()



    NavHost(navController = nav, startDestination = Dest.List.route) {
        composable(Dest.List.route) {
            UsersListScreen(
                state = uiState.value,
                onRetry = vm::refresh,
                onUserClick = { user -> nav.navigate(Dest.Detail.create(user.id)) }
            )
        }
        composable(
            route = Dest.Detail.route,
            arguments = listOf(navArgument("userId") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("userId") ?: return@composable
            vm.userById(id)?.let { user ->
                UserDetailScreen(user)
            }
        }
    }
}