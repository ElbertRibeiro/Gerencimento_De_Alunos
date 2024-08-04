package navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import view.CadastrarAlunos
import view.EditStudentScreen.editStudentData
import view.buscarAlunos
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
            buscarAlunos(navController = navController)
        }
        composable(route = "CadastrarAlunos") {
            CadastrarAlunos(navController = navController)
        }

        composable(
            route = "EditStudent/{name}",
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ) { backStackEntry ->
            editStudentData(navController = navController, backStackEntry.arguments?.getString("name") ?: "")
        }
    }
}
