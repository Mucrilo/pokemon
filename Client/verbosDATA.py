import requests

from auxiliar import *

def tipo_data():
    print('Entre com um tipo:')
    tipo_data = {
                "tipo": str(input())
            }
    return tipo_data

def habilidade_data():
    print('Entre com uma habilidade:')
    habilidade_data = {
                "habilidade": str(input())
            }
    return habilidade_data

def fraqueza_data():
    print('Entre com uma fraqueza:')
    fraqueza_data = {
                "fraqueza": str(input())
            }
    return fraqueza_data

def pokebola_data(url):
    print('Entre com o tipo(Normal, Master, Ultra):')
    tipo = str(input())
    
    print('Entre com o id do treinador:')
    print(listarIDs(requests.get(url+'treinador')))
    idTreinador = int(input())
    
    print('Entre com o id do pokemon (0 nulo):')
    print(listarIDs(requests.get(url+'pokemon')))
    idPokemon = int(input())
    
    pokebola_data = {
    "tipo": tipo,
    "idTreinador": idTreinador,
    "idPokemon": idPokemon
}
    return pokebola_data

def treinador_data():
    print('Entre com o nome do treinador:')
    nome = str(input())
    
    print('Entre com o XP do treinador:')
    xp = int(input())
    
    treinador_data = {
        "nome": nome,
        "xp": xp
    }
    return treinador_data

def pokemon_data(url):
    print('Entre com o nome do pokemon:')
    nome = str(input())
    
    print('Entre com a altura do pokemon:')
    altura = float(input())
    
    print('Entre com o peso do pokemon:')
    peso = float(input())
    
    print('Entre com o hp(vida) do pokemon:')
    vida = int(input())
    
    print('Entre com o ataque do pokemon:')
    ataque = int(input())
    
    print('Entre com a defesa do pokemon:')
    defesa = int(input())
    
    print('Entre com o ataque especial do pokemon:')
    ataqueSP = int(input())
    
    print('Entre com a defesa especial do pokemon:')
    defesaSP = int(input())
    
    print('Entre com a velocidade do pokemon:')
    velocidade = int(input())
    
    print('Entre com o(s) tipo(s) do pokemon (0 sair):')
    print(listarIDs(requests.get(url+'tipo')))
    tipo  = int(input())
    tipos = []
    while not (tipo == 0):
        tipos.append(tipo)
        tipo = int(input())
    
    print('Entre com a(s) habilidade(s) do pokemon (0 sair):')
    print(listarIDs(requests.get(url+'habilidade')))
    habilidade  = int(input())
    habilidades = []
    while not (habilidade == 0):
        habilidades.append(habilidade)
        habilidade = int(input())
    
    print('Entre com a(s) fraqueza(s) do pokemon (0 sair):')
    print(listarIDs(requests.get(url+'fraqueza')))
    fraqueza  = int(input())
    fraquezas = []
    while not (fraqueza == 0):
        fraquezas.append(fraqueza)
        fraqueza = int(input())
        
    pokemon_data = {
        "nome": nome,
        "altura": altura,
        "peso": peso,
        "vida": vida,
        "ataque": ataque,
        "defesa": defesa,
        "ataqueSP": ataqueSP,
        "defesaSP": defesaSP,
        "velocidade": velocidade,
        "tipos": tipos,
        "habilidades": habilidades,
        "fraquezas": fraquezas
    }
    return pokemon_data