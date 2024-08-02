package domain.studant

import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

object StudantRepository {
    fun addUser(name: String, age: Int) {
        transaction {
            Users.insert {
                it[Users.name] = name
                it[Users.age] = age
            }
        }
    }

    fun getAllUsers(): List<StudantDto> {
        return transaction {
            Users.selectAll().map {
                StudantDto(it[Users.name], it[Users.age])
            }
        }
    }

    fun findUserByName(name: String): List<StudantDto> {
        return transaction {
            Users.select { Users.name eq name }.map {
                StudantDto(it[Users.name], it[Users.age])
            }
        }
    }

    fun deleteUser(name: String) {
        transaction {
            Users.deleteWhere { Users.name eq name }
        }
    }
}

