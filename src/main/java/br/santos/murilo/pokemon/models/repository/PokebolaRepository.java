package br.santos.murilo.pokemon.models.repository;

import org.springframework.data.repository.CrudRepository;

import br.santos.murilo.pokemon.models.entity.Pokebola;

public interface PokebolaRepository extends CrudRepository<Pokebola, Integer>{
	
}
