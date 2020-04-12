import app.package.calculadora

while True:
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
        print("Opção inválida,tente novamente")