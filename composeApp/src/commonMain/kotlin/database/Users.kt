package database

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object Users : IntIdTable() {
    val name = varchar("name", 50)
    val age = integer("age")
}

fun createTables() {
    transaction {
        SchemaUtils.create(Users)
    }
}
