package br.santos.murilo.pokemon.controllers;

import java.util.Optional;

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
import br.santos.murilo.pokemon.models.entity.Fraqueza;
import br.santos.murilo.pokemon.models.entity.Habilidade;
import br.santos.murilo.pokemon.models.entity.Pokemon;
import br.santos.murilo.pokemon.models.entity.Tipo;
import br.santos.murilo.pokemon.models.repository.FraquezaRepository;
import br.santos.murilo.pokemon.models.repository.HabilidadeRepository;
import br.santos.murilo.pokemon.models.repository.PokemonRepository;
import br.santos.murilo.pokemon.models.repository.TipoRepository;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

	@Autowired
	PokemonRepository pokemonRepository;

	@Autowired
	TipoRepository tipoRepository;

	@Autowired
	HabilidadeRepository habilidadeRepository;

	@Autowired
	FraquezaRepository fraquezaRepository;

	@GetMapping
	public ResponseEntity<Object> getAllPokemons(){

		return ResponseEntity.status(HttpStatus.OK).body(pokemonRepository.findAll());
	}

	@PostMapping
	public ResponseEntity<Object> savePokemon(@RequestBody PokemonDTO pokemonDTO){
		Pokemon novoPokemon = new Pokemon();
		BeanUtils.copyProperties(pokemonDTO, novoPokemon);
		
		for (Integer idTipos: pokemonDTO.getTipos()){
			Optional<Tipo> pokemonTipo = tipoRepository.findById(idTipos);

			if (!pokemonTipo.isPresent()){
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo "+ idTipos +" n??o encontrado");
			}

			novoPokemon.getTipos().add(pokemonTipo.get());
		}

		for (Integer idHabilidades: pokemonDTO.getHabilidades()){
			Optional<Habilidade> pokemonHabilidade = habilidadeRepository.findById(idHabilidades);

			if (!pokemonHabilidade.isPresent()){
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Habilidade "+ idHabilidades +" n??o encontrada");
			}

			novoPokemon.getHabilidades().add(pokemonHabilidade.get());
		}

		for (Integer idFraquezas: pokemonDTO.getFraquezas()){
			Optional<Fraqueza> pokemonFraqueza = fraquezaRepository.findById(idFraquezas);

			if (!pokemonFraqueza.isPresent()){
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fraqueza "+ idFraquezas +" n??o encontrada");
			}

			novoPokemon.getFraquezas().add(pokemonFraqueza.get());
		}

		return ResponseEntity.status(HttpStatus.OK).body(pokemonRepository.save(novoPokemon));
	}

	@PutMapping ("/{id}")
	public ResponseEntity<Object> updatePokemon( @PathVariable Integer id, @RequestBody PokemonDTO pokemonDTO){
		Optional<Pokemon> pokemonExists = pokemonRepository.findById(id);

		if (!pokemonExists.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("N??o encontrado");
		}

		Pokemon atualizarPokemon = pokemonExists.get();
		BeanUtils.copyProperties(pokemonDTO, atualizarPokemon);

		for (Integer idTipos: pokemonDTO.getTipos()){
			Optional<Tipo> pokemonTipo = tipoRepository.findById(idTipos);

			if (!pokemonTipo.isPresent()){
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo "+ idTipos +" n??o encontrado");
			}

			atualizarPokemon.getTipos().add(pokemonTipo.get());
		}

		for (Integer idHabilidades: pokemonDTO.getHabilidades()){
			Optional<Habilidade> pokemonHabilidade = habilidadeRepository.findById(idHabilidades);

			if (!pokemonHabilidade.isPresent()){
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Habilidade "+ idHabilidades +" n??o encontrada");
			}

			atualizarPokemon.getHabilidades().add(pokemonHabilidade.get());
		}

		for (Integer idFraquezas: pokemonDTO.getFraquezas()){
			Optional<Fraqueza> pokemonFraqueza = fraquezaRepository.findById(idFraquezas);

			if (!pokemonFraqueza.isPresent()){
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fraqueza "+ idFraquezas +" n??o encontrada");
			}

			atualizarPokemon.getFraquezas().add(pokemonFraqueza.get());
		}

		return ResponseEntity.status(HttpStatus.OK).body(pokemonRepository.save(atualizarPokemon));
	}

	@DeleteMapping ("/{id}")
	public ResponseEntity<Object> deletePokemon( @PathVariable Integer id ){
		Optional<Pokemon> pokemonExists = pokemonRepository.findById(id);
		
		if (!pokemonExists.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("N??o encontrado");
		}

		pokemonRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Pokemon exclu??do com sucesso");
	}
}
