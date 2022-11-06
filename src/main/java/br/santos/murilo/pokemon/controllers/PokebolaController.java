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

import br.santos.murilo.pokemon.models.dto.PokebolaDTO;
import br.santos.murilo.pokemon.models.entity.Pokebola;
import br.santos.murilo.pokemon.models.entity.Pokemon;
import br.santos.murilo.pokemon.models.entity.Treinador;
import br.santos.murilo.pokemon.models.repository.PokebolaRepository;
import br.santos.murilo.pokemon.models.repository.PokemonRepository;
import br.santos.murilo.pokemon.models.repository.TreinadorRepository;

@RestController
@RequestMapping("/pokebola")
public class PokebolaController {

	@Autowired
	PokebolaRepository pokebolaRepository;

	@Autowired
	TreinadorRepository treinadorRepository;

	@Autowired
	PokemonRepository pokemonRepository;
	
	@GetMapping
	public ResponseEntity<Object> getAllPokebolas(){

		return ResponseEntity.status(HttpStatus.OK).body(pokebolaRepository.findAll());
	}

	@PostMapping
	public ResponseEntity<Object> savePokebola(@RequestBody PokebolaDTO pokebolaDTO){
		Pokebola novaPokebola = new Pokebola();
		BeanUtils.copyProperties(pokebolaDTO, novaPokebola);

		Optional<Treinador> pokebolaTreinador = treinadorRepository.findById(pokebolaDTO.getIdTreinador());
		
		if(pokebolaTreinador.isPresent()){
			novaPokebola.setTreinador(pokebolaTreinador.get());
		}

		Optional<Pokemon> pokebolaPokemon = pokemonRepository.findById(pokebolaDTO.getIdPokemon());
		
		if(pokebolaPokemon.isPresent()){
			novaPokebola.setPokemon(pokebolaPokemon.get());
		}else{
			novaPokebola.setPokemon(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(pokebolaRepository.save(novaPokebola));
	}

	@PutMapping ("/{id}")
	public ResponseEntity<Object> updatePokebola(@PathVariable Integer id, @RequestBody PokebolaDTO pokebolaDTO ){
		Optional<Pokebola> pokebolaExists = pokebolaRepository.findById(id);

		if(!pokebolaExists.isPresent() ){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pokebola não encontrado");
		}

		Pokebola atualizaPokebola = pokebolaExists.get();
		BeanUtils.copyProperties(pokebolaDTO, atualizaPokebola);

		Optional<Treinador> pokebolaTreinador = treinadorRepository.findById(pokebolaDTO.getIdTreinador());
		
		if(pokebolaTreinador.isPresent()){
			atualizaPokebola.setTreinador(pokebolaTreinador.get());
		}

		Optional<Pokemon> pokebolaPokemon = pokemonRepository.findById(pokebolaDTO.getIdPokemon());
		
		if(pokebolaPokemon.isPresent()){
			atualizaPokebola.setPokemon(pokebolaPokemon.get());
		}else{
			atualizaPokebola.setPokemon(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(pokebolaRepository.save(atualizaPokebola));
	}

	@DeleteMapping ("/{id}")
	public ResponseEntity<Object> deletePokebola(@PathVariable Integer id ){
		Optional<Pokebola> pokebolaExists = pokebolaRepository.findById(id);
		
		if(!pokebolaExists.isPresent() ){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");
		}

		pokebolaRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Pokebola excluída com sucesso");
	}
}
