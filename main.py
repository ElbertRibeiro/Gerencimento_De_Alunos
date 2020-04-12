import app.package.calculadora
import app.package.createDb

'''while True:
    print("1. Soma")
    print("2. Subtração")
    print("3. Multiplicação")
    print("4. Divisão")
    op=int(input("Que operação deseja realizar: "))
    x=float(input("Primeiro numero: "))
    y=float(input("Segundo  numero: "))

    if op==1:
        print("Soma:", app.package.calculadora.soma(x,y))
    elif op==2:
        print("Subtração:", app.package.calculadora.subtracao(x,y))
    elif op==3:
        print("Multiplicação:", app.package.calculadora.multiplicacao(x,y))
    elif op==4:
        print("Divisão:", app.package.calculadora.divisao(x,y))
    else:
        print("Opção inválida,tente novamente")'''


opcao = 0
while opcao !=7:
    print("1 = Criar banco de dados")
    opcao = int(input("Escolha sua opcao:"))
    #criando db
    if opcao == 1:
        print( app.package.createDb.createDb())