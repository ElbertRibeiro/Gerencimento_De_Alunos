package view

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun home(navController: NavController) {
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
    ){
        Text("Home")
    }
}