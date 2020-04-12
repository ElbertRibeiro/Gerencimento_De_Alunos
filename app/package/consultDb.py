import sqlite3

def consultDb():
    databaseFile = "app/database/alunos.db"
    conn = sqlite3.connect(databaseFile)

    cursor = conn.cursor()
    cursor.execute("""
    SELECT * FROM  alunos;
    """)
    for linha in cursor.fetchall():
        print(linha)
    conn.close()

