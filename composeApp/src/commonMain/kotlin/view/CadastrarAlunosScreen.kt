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
import component.alertDialog
import domain.studant.UserRepository.addUser

@Composable
fun CadastrarAlunos(navController: NavHostController) {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var submitted by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        alertDialog(
            onConfirmation = { showDialog = false },
            dialogTitle = "Dados Inválidos",
            dialogText = "Verificar se todos os campos exigidos estão preenchidos"
        )
    }

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
                alertDialog(
                    onConfirmation = { navController.navigate("CadastrarAlunos") },
                    dialogTitle = "Cadastro realizado com sucesso!",
                    dialogText = ""
                )
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
                    onValueChange = { newValue ->
                        if (newValue.all { it.isDigit() }) {
                            age = newValue
                        }
                    },
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
                            addUser(name, age.toInt())
                        } else {
                            showDialog = true
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