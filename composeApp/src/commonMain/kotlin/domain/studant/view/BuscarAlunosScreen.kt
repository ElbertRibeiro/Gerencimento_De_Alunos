package domain.studant.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
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

            LazyColumn {
                if (text.isNotEmpty()) {
                    items(findUserByName(text)) { user ->
                        Text("Nome: ${user.name}, Idade: ${user.age}")
                    }
                } else {
                    items(studants) { studant ->
                        Text("Nome: ${studant.name}, Idade: ${studant.age}")
                    }
                }
            }
        }
    }
}
