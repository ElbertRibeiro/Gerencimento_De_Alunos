import sqlite3


def deleteDb():
    databaseFile = "app/database/alunos.db"
    conn = sqlite3.connect(databaseFile)

    cursor = conn.cursor()
    id_numpasta = input('Numero da pasta: ')
    
    cursor.execute("""
          DELETE FROM alunos
          WHERE id_numpasta = ?
          """, (id_numpasta,))
    conn.commit()
    print('Registro excluido com sucesso.')
    conn.close()
