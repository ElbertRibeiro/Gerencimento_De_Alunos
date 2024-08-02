package domain.studant

import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

object StudantRepository {
    fun addUser(name: String, age: Int) {
        transaction {
            Studant.insert {
                it[Studant.name] = name
                it[Studant.age] = age
            }
        }
    }

    fun getAllUsers(): List<StudantDto> {
        return transaction {
            Studant.selectAll().map {
                StudantDto(it[Studant.name], it[Studant.age])
            }
        }
    }

    fun findUserByName(name: String): List<StudantDto> {
        return transaction {
            Studant.select { Studant.name eq name }.map {
                StudantDto(it[Studant.name], it[Studant.age])
            }
        }
    }

    fun deleteUser(name: String) {
        transaction {
            Studant.deleteWhere { Studant.name eq name }
        }
    }
}

