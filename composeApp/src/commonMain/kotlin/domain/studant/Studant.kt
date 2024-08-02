package domain.studant

import org.jetbrains.exposed.dao.id.IntIdTable

object Studant : IntIdTable() {
    val name = varchar("name", 50)
    val age = integer("age")
}
