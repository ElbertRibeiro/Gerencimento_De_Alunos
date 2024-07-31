package database

import domain.studant.entity.Users
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun initDatabase() {
    Database.connect(url = "jdbc:sqlite:data.db", driver = "org.sqlite.JDBC")
}

fun createTables() {
    transaction {
        SchemaUtils.create(Users)
    }
}
