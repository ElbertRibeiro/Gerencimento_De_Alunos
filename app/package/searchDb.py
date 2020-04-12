import sqlite3


def searchDb():

    databaseFile = "app/database/alunos.db"
    conn = sqlite3.connect(databaseFile)

    cursor = conn.cursor()

    p_nome = input('Digite o nome do aluno: ')
    cursor.execute("""
          SELECT * FROM alunos WHERE nome like ?
          """, (p_nome + '%',))
    for linha in cursor.fetchall():
        print(linha)

    print('---Busca concluida---')
    conn.close()
