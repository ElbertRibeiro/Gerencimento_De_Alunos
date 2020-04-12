import sqlite3

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
