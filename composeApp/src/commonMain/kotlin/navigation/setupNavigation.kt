package navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import view.BuscarAlunos
import view.CadastrarAlunos

@Composable
fun setupNavigation() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation {
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Search, contentDescription = "Buscar Alunos") },
                    label = { Text("Buscar Alunos") },
                    selected = false,
                    onClick = { navController.navigate("BuscarAlunos") }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Add, contentDescription = "Cadastrar Alunos") },
                    label = { Text("Cadastrar Alunos") },
                    selected = false,
                    onClick = { navController.navigate("CadastrarAlunos") }
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "BuscarAlunos",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = "BuscarAlunos") {
                BuscarAlunos(navController = navController)
            }
            composable(route = "CadastrarAlunos") {
                CadastrarAlunos(navController = navController)
            }
        }
    }
}
