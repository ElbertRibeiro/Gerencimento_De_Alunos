package database

import org.jetbrains.exposed.sql.Database

fun initDatabase() {
    Database.connect(url = "jdbc:sqlite:data.db", driver = "org.sqlite.JDBC")
}
