package br.santos.murilo.pokemon.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/treinador")
public class TreinadorController {
	
	@GetMapping
	public ResponseEntity<Object> getAllTreinadores(){

		return ResponseEntity.status(HttpStatus.OK).body("Invocou o GET");
	}

	@PostMapping
	public ResponseEntity<Object> saveTreinador(){

		return ResponseEntity.status(HttpStatus.OK).body("Invocou o POST");
	}

	@PutMapping ("/{id}")
	public ResponseEntity<Object> updateTreinador( @PathVariable Integer id ){

		return ResponseEntity.status(HttpStatus.OK).body("Invocou o PUT -> " + id);
	}

	@DeleteMapping ("/{id}")
	public ResponseEntity<Object> deleteTreinador( @PathVariable Integer id ){

		return ResponseEntity.status(HttpStatus.OK).body("Invocou o DELETE -> " + id);
	}
}
