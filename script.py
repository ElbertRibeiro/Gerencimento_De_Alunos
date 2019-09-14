import sqlite3
from time import sleep

opcao = 0
while opcao !=7:
    print("""
        1 = Criar banco de dados
        2 = Ler dados
        3 = Inserir dados
        4 = Deletando dados
        5 = Alterando dados
        6 = Pesuisar aluno
        7 = Sair do programa
        """)
    opcao = int(input("Escolha sua opcao:"))
    #criando db
    if opcao == 1:
        conn = sqlite3.connect('alunos.db')
        # definindo um cursor
        cursor = conn.cursor()
        # criando uma tabela (schema)
        cursor.execute("""
        CREATE TABLE alunos (
            id_numpasta INTEGER NOT NULL PRIMARY KEY,
            nome TEXT NOT NULL,
            idade INTEGER,
            cpf VARCHAR(11) NOT NULL,
            turma TEXT NOT NULL,
            ano NUMERIC(4),
            situacao TEXT,
            pedencias TEXT,
            fone TEXT,
            cidade TEXT,
            responsavel TEXT NOT NULL
            );""")
        print('Tabela criada com sucesso')
        # desconectando...
        # encerrando a conecção com o db
        conn.close()

    # ler dados
    elif opcao == 2:
          conn = sqlite3.connect('alunos.db')
          cursor = conn.cursor()
          # lendo os dados
          cursor.execute("""
          SELECT * FROM  alunos;
          """)
          for linha in cursor.fetchall():
              print(linha)
          conn.close()

    #inserir dados
    elif opcao == 3:
          conn = sqlite3.connect('alunos.db')
          cursor = conn.cursor()
          # solicitando os dados do usuário
          p_numpasta = input('Numero da pasta: ')
          p_nome = input('Nome: ')
          p_idade = input('Idade: ')
          p_cpf = input('CPF: ')
          p_turma = input('Turma: ')
          p_ano = input('Ano: ')
          p_situacao = input('Situação: ')
          p_pedencias = input('Pendências: ')
          p_fone = input('Fone: ')
          p_cidade = input('Cidade: ')
          p_responsavel = input('Responsável: ')
          
          # inserindo os dados na tabela
          cursor.execute("""
          INSERT INTO alunos (id_numpasta, nome, idade, cpf, turma, ano, situacao, pedencias, fone, cidade, responsavel)
          VALUES (?,?,?,?,?,?,?,?,?,?,?)
          """, (p_numpasta, p_nome, p_idade, p_cpf, p_turma, p_ano, p_situacao, p_pedencias, p_fone, p_cidade, p_responsavel,))
          conn.commit()
          print('Dados inseridos com sucesso')
          conn.close

    #deletando dados
    elif opcao == 4:
          conn = sqlite3.connect('alunos.db')
          cursor = conn.cursor()
          id_numpasta = input('Numero da pasta: ')
          # excluindo um registro da tabela
          cursor.execute("""
          DELETE FROM alunos
          WHERE id_numpasta = ?
          """, (id_numpasta,))
          conn.commit()
          print('Registro excluido com sucesso.')
          conn.close()

    #alterando dados
    elif opcao == 5:
          conn = sqlite3.connect('alunos.db')
          cursor = conn.cursor()
          # idermos definir o id a ser alterado
          id_cliente = 1
          # como usamos o fone como parametro
          # iremos criara um novo fone
          novo_fone = '11-1000-2014'
          novo_criado_em = '2014-06-11'
          # alterando os dados da tabela
          cursor.execute("""
          UPDATE alunos
          SET fone = ?, criado_em = ?
          WHERE id = ?
          """, (novo_fone, novo_criado_em, id_cliente))
          conn.commit()
          print('Dados alterados com sucesso')
          conn.close()

    #buscando dados
    elif opcao == 6:
          conn = sqlite3.connect('alunos.db')
          cursor = conn.cursor()
          #definir nome a ser consultado
          p_nome = input('Digite o nome do aluno: ')
          cursor.execute("""
          SELECT * FROM alunos WHERE nome like ?
          """, (p_nome + '%',))
          for linha in cursor.fetchall():
              print(linha)
          #conn.commit()
          print('---Busca concluida---')
          conn.close()
    elif opcao == 7:
        print('Finalizando...')
    else:
        print('Opção invalida, tente novamente!!!')
    print('=-=' * 10)
    sleep(2)
print("---Saindo do programa---")