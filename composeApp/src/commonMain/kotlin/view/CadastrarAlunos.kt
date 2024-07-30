package view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun CadastrarAlunos(navController: NavHostController) {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var submitted by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cadastrar Alunos") },
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
        Column(modifier = Modifier.padding(16.dp)) {
            if (submitted) {
                Text("Cadastro realizado com sucesso!", style = MaterialTheme.typography.h6)
            } else {
                Text("Formulário de Cadastro de Aluno", style = MaterialTheme.typography.h6)
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Nome") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = age,
                    onValueChange = { age = it },
                    label = { Text("Idade") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )
                Spacer(modifier = Modifier.height(16.dp))

                Row {
                    Button(onClick = {
                        if (name.isNotBlank() && age.isNotBlank() && email.isNotBlank()) {
                            submitted = true
                        } else {
                            // Aqui você pode adicionar lógica para lidar com campos não preenchidos
                        }
                    }) {
                        Text("Cadastrar")
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Button(onClick = {
                        name = ""
                        age = ""
                        email = ""
                    }) {
                        Text("Limpar")
                    }
                }


            }
        }
    }
}