import app.package.createDb
import app.package.consultDb
import app.package.insertDb
import app.package.deleteDb
import app.package.changeDb
import app.package.searchDb
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
    
    if opcao == 1:
        print( app.package.createDb.createDb() )

    elif opcao == 2:
        print ( app.package.consultDb.consultDb() )

    elif opcao == 3:
        print ( app.package.insertDb.insertDb() )

    elif opcao == 4:
        print( app.package.deleteDb.deleteDb() )
    
    elif opcao == 5:
        print( app.package.changeDb.changeDb() )

    elif opcao == 6:
        print( app.package.searchDb.searchDb() )

    elif opcao == 7:
        print('Finalizando...')

    else:
        print('Opção invalida, tente novamente!!!')
    print('=-=' * 10)
    sleep(2)


print("---Saindo do programa---")