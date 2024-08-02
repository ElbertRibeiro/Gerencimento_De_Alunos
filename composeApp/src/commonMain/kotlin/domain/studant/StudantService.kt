package domain.studant

import domain.studant.StudantRepository.deleteUser
import domain.studant.StudantRepository.updateUser

object StudantService {

    fun deleteStudant(studantId: String): String {
        deleteUser(studantId)
        return "O registro do estudante $studantId foi deletado"
    }

    fun updateStudent(name: String, age: Int) {
        updateUser(name, age)
    }
}