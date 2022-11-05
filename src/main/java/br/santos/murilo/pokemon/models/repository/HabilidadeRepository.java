package br.santos.murilo.pokemon.models.repository;

import org.springframework.data.repository.CrudRepository;

import br.santos.murilo.pokemon.models.entity.Habilidade;

public interface HabilidadeRepository extends CrudRepository<Habilidade, Integer>{
	
}
