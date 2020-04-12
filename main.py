import app.package.createDb
import app.package.consultDb
import app.package.insertDb
import app.package.deleteDb

opcao = 0
while opcao !=7:
    
    opcao = int(input("Escolha sua opcao:"))
    
    if opcao == 1:
        print( app.package.createDb.createDb() )

    elif opcao == 2:
        print ( app.package.consultDb.consultDb() )

    elif opcao == 3:
        print ( app.package.insertDb.insertDb() )

    elif opcao == 4:
        print( app.package.deleteDb.deleteDb() )