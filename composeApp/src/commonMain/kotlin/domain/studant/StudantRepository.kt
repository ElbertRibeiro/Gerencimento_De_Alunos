package domain.studant

import org.jetbrains.exposed.sql.*
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

    fun updateUser(name: String, newAge: Int) {
        transaction {
            Studant.update({
                Studant.name eq name
            }) {
                it[age] = newAge
            }
        }
    }
}

