package navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import view.BuscarAlunos
import view.CadastrarAlunos
import view.Home

@Composable
fun setupNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "Home"
    ) {
        composable(
            route = "Home"
        ) {
            Home(navController = navController)
        }

        composable(
            route = "BuscarAlunos"
        ) {
            BuscarAlunos(navController = navController)
        }

        composable(
            route = "CadastrarAlunos"
        ) {
            CadastrarAlunos(navController = navController)
        }
    }

}
