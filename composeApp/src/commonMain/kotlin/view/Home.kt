package view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun Home(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Home Screen")
        Button(
            onClick = { navController.navigate("SegundaTela") },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Blue
            )
        ){
            Text("Navegar")
        }

        Button(
            onClick = { navController.navigate("CadastrarAlunos") },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Blue
            )
        ){
            Text("Cadastro de Alunos")
        }
    }
}