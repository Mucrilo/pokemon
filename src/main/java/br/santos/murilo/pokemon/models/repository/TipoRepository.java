package br.santos.murilo.pokemon.models.repository;

import org.springframework.data.repository.CrudRepository;

import br.santos.murilo.pokemon.models.entity.Tipo;

public interface TipoRepository extends CrudRepository<Tipo, Integer>{
	
}
