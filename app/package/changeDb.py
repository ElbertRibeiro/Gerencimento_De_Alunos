import sqlite3


def changeDb():
    databaseFile = "app/database/alunos.db"
    
    escolha = 0
    while escolha != 4:
        print("""
              1 = Numero para contato
              2 = Situação escolar
              3 = Documentações pendentes
              4 = Sair do menu
              """)
        escolha = int(input("Escolha sua opção: "))
        if escolha == 1:
            conn = sqlite3.connect(databaseFile)
            cursor = conn.cursor()
            
            id_numpasta = input(
                'Digite o  numero da pasta para alterar os dados: ')
            
            novo_fone = input("Digite um novo numero para contato: ")
            
            cursor.execute("""
                  UPDATE alunos
                  SET fone = ?
                  WHERE id_numpasta = ?
                  """, (novo_fone, id_numpasta,))
            conn.commit()
            print('Dados alterados com sucesso')

        elif escolha == 2:
            conn = sqlite3.connect(databaseFile)
            cursor = conn.cursor()
            
            id_numpasta = input(
                'Digite o  numero da pasta para alterar os dados: ')
            
            novo_situacao = input("Digite a atual situação escolar: ")
            
            cursor.execute("""
                  UPDATE alunos
                  SET situacao = ?
                  WHERE id_numpasta = ?
                  """, (novo_situacao, id_numpasta,))
            conn.commit()
            print('Dados alterados com sucesso')

        elif escolha == 3:
            conn = sqlite3.connect(databaseFile)
            cursor = conn.cursor()
            id_numpasta = input(
                'Digite o  numero da pasta para alterar os dados: ')
            novo_pedencias = input('Digite a atualização de pendencias: ')
            cursor.execute("""
                  UPDATE alunos
                  SET pedencias = ?
                  WHERE id_numpasta = ?
                  """, (novo_pedencias, id_numpasta,))
            conn.commit()
            print('Dados alterados com sucesso')

        elif escolha == 4:
            conn = sqlite3.connect(databaseFile)
            cursor = conn.cursor()
            print('Saindo...')
            conn.close()

        else:
            print('Opção invalida, tente novamente!!!')
        print('-----------' * 10)
