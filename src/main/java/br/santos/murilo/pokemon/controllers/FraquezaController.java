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

import br.santos.murilo.pokemon.models.dto.FraquezaDTO;
import br.santos.murilo.pokemon.models.entity.Fraqueza;
import br.santos.murilo.pokemon.models.repository.FraquezaRepository;

@RestController
@RequestMapping("/fraqueza")
public class FraquezaController {
	
	@Autowired
	FraquezaRepository fraquezaRepository;

	@GetMapping
	public ResponseEntity<Object> getAllFraquezas(){

		return ResponseEntity.status(HttpStatus.OK).body(fraquezaRepository.findAll());
	}

	@PostMapping
	public ResponseEntity<Object> saveFraqueza(@RequestBody FraquezaDTO fraquezaDTO){
		Fraqueza novaFraqueza = new Fraqueza();
		BeanUtils.copyProperties(fraquezaDTO, novaFraqueza);

		return ResponseEntity.status(HttpStatus.OK).body(fraquezaRepository.save(novaFraqueza));
	}

	@PutMapping ("/{id}")
	public ResponseEntity<Object> updateFraqueza( @PathVariable Integer id, @RequestBody FraquezaDTO fraquezaDTO ){
		Optional<Fraqueza> fraquezaExists = fraquezaRepository.findById(id);

		if (!fraquezaExists.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");
		}

		Fraqueza atualizaFraqueza = fraquezaExists.get();

		BeanUtils.copyProperties(fraquezaDTO, atualizaFraqueza);

		return ResponseEntity.status(HttpStatus.OK).body(fraquezaRepository.save(atualizaFraqueza));
	}

	@DeleteMapping ("/{id}")
	public ResponseEntity<Object> deleteFraqueza( @PathVariable Integer id ){
		Optional<Fraqueza> fraquezaExists = fraquezaRepository.findById(id);

		if (!fraquezaExists.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");
		}

		fraquezaRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Fraqueza excluída com sucesso");
	}
}
