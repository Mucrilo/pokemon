from endpoints import *

url = "http://localhost:8080/"

def verbo():
    print('Escolha um verbo:')
    print('1: GET    2: POST    3: PUT    4: DELETE')
    
    return int(input())

while True:
    print('Escolhe um:')
    print('0: Sair')
    print('1: Tipo')
    print('2: Habilidade')
    print('3: Fraqueza')
    print('4: Pokemon')
    print('5: Pokebola')
    print('6: Treinador')

    match int(input()):
        case 1:
            print(tipo(url, verbo()).text)
        case 2:
            print(habilidade(url, verbo()).text)
        case 3:
            print(fraqueza(url, verbo()).text)
        case 4:
            print(pokemon(url, verbo()).text)
        case 5:
            print(pokebola(url, verbo()).text)
        case 6:
            print(treinador(url, verbo()).text)
        case 0:
            exit()


