package database

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyApp() {
    var users by remember { mutableStateOf(listOf<User>()) }
    var name by remember { mutableStateOf("") }
    users = UserRepository.getAllUsers()


    Column {
        Text("Formulário de Teste", style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nome") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            UserRepository.addUser(name, 30)
            users = UserRepository.getAllUsers()
        }) {
            Text("Add User")
        }
        users.forEach {
            Text("User: ${it.name}, Age: ${it.age}")
        }
    }
}