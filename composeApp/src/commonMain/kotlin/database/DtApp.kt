package database

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*

@Composable
fun MyApp() {
    var users by remember { mutableStateOf(listOf<User>()) }

    Column {
        Button(onClick = {
            UserRepository.addUser("John Doe", 30)
            users = UserRepository.getAllUsers()
        }) {
            Text("Add User")
        }
        users.forEach {
            Text("User: ${it.name}, Age: ${it.age}")
        }
    }
}