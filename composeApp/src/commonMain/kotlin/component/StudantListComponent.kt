package component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import domain.studant.dto.User

object StudantListComponent {

    @Composable
    fun studantList(studants: List<User>) {
        LazyColumn {
            items(studants) { user ->
                Card(
                    elevation = 3.dp,
                    modifier = Modifier.padding(20.dp, 0.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp, vertical = 8.dp)
                    ) {
                        Text(
                            text = "Nome aluno: ${user.name}",
                            style = MaterialTheme.typography.body1,
                            modifier = Modifier.weight(1f)
                                .align(alignment = Alignment.CenterVertically),
                        )
                        Text(
                            text = "${user.age} anos",
                            style = MaterialTheme.typography.body1,
                            modifier = Modifier.weight(1f)
                                .align(alignment = Alignment.CenterVertically),
                        )
                        Button(
                            onClick = { },
                        ) {
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = "Edit",
                            )
                        }
                    }
                }
            }
        }
    }
}