import sqlite3

def createDb():
    conn = sqlite3.connect('..database.alunos.db')
    # definindo um cursor
    cursor = conn.cursor()
    # criando uma tabela (schema)
    cursor.execute("""
        CREATE TABLE ..database.alunos (
            id_numpasta TEXT NOT NULL,
            nome TEXT NOT NULL,
            idade INTEGER,
            cpf VARCHAR(11) NOT NULL PRIMARY KEY,
            turma TEXT NOT NULL,
            ano NUMERIC(4),
            situacao TEXT,
            pedencias TEXT,
            fone TEXT,
            cidade TEXT,
            responsavel TEXT NOT NULL
            );""")
    # desconectando...
    # encerrando a conecção com o db
    conn.close()

    return ('Tabela criada com sucesso')
