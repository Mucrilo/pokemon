package br.santos.murilo.pokemon.models.repository;

import org.springframework.data.repository.CrudRepository;

import br.santos.murilo.pokemon.models.entity.Treinador;

public interface TreinadorRepository extends CrudRepository<Treinador, Integer>{
	
}
