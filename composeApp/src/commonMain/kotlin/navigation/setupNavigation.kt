package navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import view.BuscarAlunos
import view.CadastrarAlunos
import view.home

@Composable
fun setupNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "Home",
    ) {
        composable("Home") {
            home(navController = navController)
        }

        composable(route = "BuscarAlunos") {
            BuscarAlunos(navController = navController)
        }
        composable(route = "CadastrarAlunos") {
            CadastrarAlunos(navController = navController)
        }
    }
}
