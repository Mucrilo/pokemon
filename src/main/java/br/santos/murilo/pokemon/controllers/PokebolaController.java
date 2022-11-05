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

import br.santos.murilo.pokemon.models.dto.PokebolaDTO;
import br.santos.murilo.pokemon.models.entity.Pokebola;
import br.santos.murilo.pokemon.models.repository.PokebolaRepository;

@RestController
@RequestMapping("/pokebola")
public class PokebolaController {

	@Autowired
	PokebolaRepository pokebolaRepository;
	
	@GetMapping
	public ResponseEntity<Object> getAllPokebolas(){

		return ResponseEntity.status(HttpStatus.OK).body(pokebolaRepository.findAll());
	}

	@PostMapping
	public ResponseEntity<Object> savePokebola(@RequestBody PokebolaDTO pokebolaDTO){
		Pokebola pokebolaEntity = new Pokebola();
		BeanUtils.copyProperties(pokebolaDTO, pokebolaEntity);

		return ResponseEntity.status(HttpStatus.OK).body(pokebolaRepository.save(pokebolaEntity));
	}

	@PutMapping ("/{id}")
	public ResponseEntity<Object> updatePokebola( @PathVariable Integer id ){

		return ResponseEntity.status(HttpStatus.OK).body("Invocou o PUT -> " + id);
	}

	@DeleteMapping ("/{id}")
	public ResponseEntity<Object> deletePokebola( @PathVariable Integer id ){

		return ResponseEntity.status(HttpStatus.OK).body("Invocou o DELETE -> " + id);
	}
}
