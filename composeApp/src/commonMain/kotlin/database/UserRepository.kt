package database

import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

object UserRepository {
    fun addUser(name: String, age: Int) {
        transaction {
            Users.insert {
                it[Users.name] = name
                it[Users.age] = age
            }
        }
    }

    fun getAllUsers(): List<User> {
        return transaction {
            Users.selectAll().map {
                User(it[Users.name], it[Users.age])
            }
        }
    }

    fun findUserByName(name: String): List<User> {
        return transaction {
            Users.select { Users.name eq name }.map {
                User(it[Users.name], it[Users.age])
            }
        }
    }
}

