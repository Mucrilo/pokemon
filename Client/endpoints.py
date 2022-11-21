import requests

from auxiliar import *
from verbosDATA import *

def tipo(url, verbo):
    match verbo:
        case 1:
            return requests.get(url+'tipo')
        case 2:
            return requests.post(url+'tipo', json=tipo_data())
        case 3:
            ids = listarIDs(tipo(url, 1))
            if ids == '':
                print('Sem tipos para alterar')
                return tipo(url, 1)
            else:
                print('Qual tipo deseja alterar:')
                print(ids)
                return requests.put(url+'tipo/'+str(input()), json=tipo_data())
        case 4:
            ids = listarIDs(tipo(url, 1))
            if ids == '':
                print('Sem tipos para deletar')
                return tipo(url, 1)
            else:
                print('Qual tipo deseja deletar:')
                print(ids)
                return requests.delete(url+'tipo/'+str(input()))

def habilidade(url, verbo):
    match verbo:
        case 1:
            return requests.get(url+'habilidade')
        case 2:
            return requests.post(url+'habilidade', json=habilidade_data())
        case 3:
            ids = listarIDs(habilidade(url, 1))
            if ids == '':
                print('Sem habilidades para alterar')
                return habilidade(url, 1)
            else:
                print('Qual habilidade deseja alterar:')
                print(ids)
                return requests.put(url+'habilidade/'+str(input()), json=habilidade_data())
        case 4:
            ids = listarIDs(habilidade(url, 1))
            if ids == '':
                print('Sem habilidades para deletar')
                return habilidade(url, 1)
            else:
                print('Qual habilidade deseja deletar:')
                print(ids)
                return requests.delete(url+'habilidade/'+str(input()))
            
def fraqueza(url, verbo):
    match verbo:
        case 1:
            return requests.get(url+'fraqueza')
        case 2:
            return requests.post(url+'fraqueza', json=fraqueza_data())
        case 3:
            ids = listarIDs(fraqueza(url, 1))
            if ids == '':
                print('Sem fraquezas para alterar')
                return fraqueza(url, 1)
            else:
                print('Qual fraqueza deseja alterar:')
                print(ids)
                return requests.put(url+'fraqueza/'+str(input()), json=fraqueza_data())
        case 4:
            ids = listarIDs(fraqueza(url, 1))
            if ids == '':
                print('Sem fraquezas para deletar')
                return fraqueza(url, 1)
            else:
                print('Qual fraqueza deseja deletar:')
                print(ids)
                return requests.delete(url+'fraqueza/'+str(input()))
            
def pokemon(url, verbo):
    match verbo:
        case 1:
            return requests.get(url+'pokemon')
        case 2:
            return requests.post(url+'pokemon', json=pokemon_data(url))
        case 3:
            ids = listarIDs(pokemon(url, 1))
            if ids == '':
                print('Sem pokemons para alterar')
                return pokemon(url, 1)
            else:
                print('Qual pokemon deseja alterar:')
                print(ids)
                return requests.put(url+'pokemon/'+str(input()), json=pokemon_data(url))
        case 4:
            ids = listarIDs(pokemon(url, 1))
            if ids == '':
                print('Sem pokemons para deletar')
                return pokemon(url, 1)
            else:
                print('Qual pokemon deseja deletar:')
                print(ids)
                return requests.delete(url+'pokemon/'+str(input()))
            
def pokebola(url, verbo):
    match verbo:
        case 1:
            return requests.get(url+'pokebola')
        case 2:
            return requests.post(url+'pokebola', json=pokebola_data(url))
        case 3:
            ids = listarIDs(pokebola(url, 1))
            if ids == '':
                print('Sem pokebolas para alterar')
                return pokebola(url, 1)
            else:
                print('Qual pokebola deseja alterar:')
                print(ids)
                return requests.put(url+'pokebola/'+str(input()), json=pokebola_data(url))
        case 4:
            ids = listarIDs(pokebola(url, 1))
            if ids == '':
                print('Sem pokebolas para deletar')
                return pokebola(url, 1)
            else:
                print('Qual pokebola deseja deletar:')
                print(ids)
                return requests.delete(url+'pokebola/'+str(input()))
            
def treinador(url, verbo):
    match verbo:
        case 1:
            return requests.get(url+'treinador')
        case 2:
            return requests.post(url+'treinador', json=treinador_data())
        case 3:
            ids = listarIDs(treinador(url, 1))
            if ids == '':
                print('Sem treinadores para alterar')
                return treinador(url, 1)
            else:
                print('Qual treinador deseja alterar:')
                print(ids)
                return requests.put(url+'treinador/'+str(input()), json=treinador_data())
        case 4:
            ids = listarIDs(treinador(url, 1))
            if ids == '':
                print('Sem treinadores para deletar')
                return treinador(url, 1)
            else:
                print('Qual treinador deseja deletar:')
                print(ids)
                return requests.delete(url+'treinador/'+str(input()))