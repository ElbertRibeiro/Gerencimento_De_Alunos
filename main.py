import app.package.createDb
import app.package.consultDb


opcao = 0
while opcao !=7:
    print ("1 = Criar banco de dados")
    opcao = int(input("Escolha sua opcao:"))
    
    if opcao == 1:
        print( app.package.createDb.createDb() )

    elif opcao == 2:
        print ( app.package.consultDb.consultDb() )