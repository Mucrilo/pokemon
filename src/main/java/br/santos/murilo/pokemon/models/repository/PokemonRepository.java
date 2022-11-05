package br.santos.murilo.pokemon.models.repository;

import org.springframework.data.repository.CrudRepository;

import br.santos.murilo.pokemon.models.entity.Pokemon;

public interface PokemonRepository extends CrudRepository<Pokemon, Integer>{
	
}
