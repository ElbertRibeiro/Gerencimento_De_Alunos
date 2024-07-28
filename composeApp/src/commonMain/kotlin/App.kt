import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import model.User
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    var users by remember { mutableStateOf(listOf<User>()) }
    var userName by remember { mutableStateOf("") }
    var searchQuery by remember { mutableStateOf("") }
    var nextId by remember { mutableStateOf(1) }

    fun addUser(name: String) {
        users = users + User(nextId, name)
        nextId++
    }

    fun searchUsers(query: String): List<User> {
        return users.filter { it.name.contains(query, ignoreCase = true) }
    }

    MaterialTheme {
        Column(
            modifier = Modifier.padding(16.dp).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Adicionar Usuário", style = MaterialTheme.typography.h5)
            Spacer(Modifier.height(8.dp))
            BasicTextField(
                value = userName,
                onValueChange = { userName = it },
                modifier = Modifier.fillMaxWidth().padding(8.dp)
                    .border(1.dp, Color.Red, RectangleShape),
                singleLine = true
            )
            Button(onClick = {
                if (userName.isNotBlank()) {
                    addUser(userName)
                    userName = ""
                }
            }) {
                Text("Adicionar")
            }
            Spacer(Modifier.height(16.dp))
            Text("Buscar Usuários", style = MaterialTheme.typography.h5)
            Spacer(Modifier.height(8.dp))
            BasicTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier.fillMaxWidth().padding(8.dp)
                    .border(1.dp, Color.Red, RectangleShape),
                singleLine = true
            )
            Spacer(Modifier.height(8.dp))
            LazyColumn {
                items(searchUsers(searchQuery)) { user ->
                    Text("ID: ${user.id}, Nome: ${user.name}")
                }
            }
        }
    }
}