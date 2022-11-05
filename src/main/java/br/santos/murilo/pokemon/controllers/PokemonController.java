package br.santos.murilo.pokemon.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.santos.murilo.pokemon.models.dto.PokemonDTO;
import br.santos.murilo.pokemon.models.entity.Pokemon;
import br.santos.murilo.pokemon.models.repository.PokemonRepository;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

	@Autowired
	PokemonRepository pokemonRepository;
	
	@GetMapping
	public ResponseEntity<Object> getAllPokemons(){

		return ResponseEntity.status(HttpStatus.OK).body(pokemonRepository.findAll());
	}

	@PostMapping
	public ResponseEntity<Object> savePokemon(@RequestBody PokemonDTO pokemonDTO){
		Pokemon pokemonEntity = new Pokemon();
		BeanUtils.copyProperties(pokemonDTO, pokemonEntity);

		return ResponseEntity.status(HttpStatus.OK).body(pokemonRepository.save(pokemonEntity));
	}

	@PutMapping ("/{id}")
	public ResponseEntity<Object> updatePokemon( @PathVariable Integer id ){

		return ResponseEntity.status(HttpStatus.OK).body("Invocou o PUT -> " + id);
	}

	@DeleteMapping ("/{id}")
	public ResponseEntity<Object> deletePokemon( @PathVariable Integer id ){

		return ResponseEntity.status(HttpStatus.OK).body("Invocou o DELETE -> " + id);
	}
}
