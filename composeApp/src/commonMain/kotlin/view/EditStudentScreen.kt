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
import component.CustomSpacer
import component.alertDialog
import domain.studant.StudantRepository.addUser

object EditStudentScreen {
    @Composable
    fun editStudentData(navController: NavHostController) {
        var name by remember { mutableStateOf("Teste") }
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
                    title = { Text("Editar Aluno") },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigate("BuscarAlunos") }) {
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
                        onConfirmation = { navController.navigate("BuscarAlunos") },
                        dialogTitle = "Dados atualizados realizado com sucesso!",
                        dialogText = ""
                    )
                } else {
                    OutlinedTextField(
                        value = name,
                        onValueChange = { },
                        label = { Text("Nome") },
                        modifier = Modifier.fillMaxWidth(),
                        readOnly = true,
                        enabled = false
                    )
                    CustomSpacer.space8pd()
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
                    CustomSpacer.space8pd()
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
                            Text("Editar")
                        }

                    }
                }
            }
        }
    }
}