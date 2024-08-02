package domain.studant

import domain.studant.StudantRepository.deleteUser

object StudantService {

    fun deleteStudant(studantId: String): String {
        deleteUser(studantId)
        return "O registro do estudante $studantId foi deletado"
    }
}