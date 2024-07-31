package domain.studant.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import component.StudantListComponent.studantList
import domain.studant.repository.UserRepository
import domain.studant.repository.UserRepository.findUserByName

@Composable
fun buscarAlunos(navController: NavController) {
    var text by remember { mutableStateOf("") }
    val studants = UserRepository.getAllUsers()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Buscar Alunos") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("Home") }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Pesquisar nome do Aluno") },
                modifier = Modifier.fillMaxWidth().padding(20.dp, 0.dp)
            )

            Spacer(Modifier.height(8.dp))

            if (text.isNotEmpty()) {
                studantList(findUserByName(text))
            } else {
                studantList(studants)
            }
        }
    }
}
