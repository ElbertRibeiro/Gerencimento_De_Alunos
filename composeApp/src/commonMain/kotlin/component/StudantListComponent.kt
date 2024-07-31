package component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import domain.studant.dto.User

object StudantListComponent {

    @Composable
    fun studantList(studants: List<User>) {
        LazyColumn {
            items(studants) { user ->
                Card(
                    elevation = 6.dp,
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Nome: ${user.name}",
                            fontSize = 20.sp,
//                            modifier = Modifier.fillMaxWidth().padding(10.dp, 10.dp),
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "Idade: ${user.age}",
                            fontSize = 20.sp,
//                            modifier = Modifier.fillMaxWidth().padding(10.dp, 10.dp),
                            textAlign = TextAlign.Center
                        )
                    }

                }

            }
        }
    }
}