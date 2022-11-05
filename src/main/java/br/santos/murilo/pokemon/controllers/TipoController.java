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

import br.santos.murilo.pokemon.models.dto.TipoDTO;
import br.santos.murilo.pokemon.models.entity.Tipo;
import br.santos.murilo.pokemon.models.repository.TipoRepository;

@RestController
@RequestMapping("/tipo")
public class TipoController {
	
	@Autowired
	TipoRepository tipoRepository;

	@GetMapping
	public ResponseEntity<Object> getAllTipos(){

		return ResponseEntity.status(HttpStatus.OK).body(tipoRepository.findAll());
	}

	@PostMapping
	public ResponseEntity<Object> saveTipo(@RequestBody TipoDTO tipoDTO){
		Tipo tipoEntity = new Tipo();
		BeanUtils.copyProperties(tipoDTO, tipoEntity);

		return ResponseEntity.status(HttpStatus.OK).body(tipoRepository.save(tipoEntity));
	}

	@PutMapping ("/{id}")
	public ResponseEntity<Object> updateTipo( @PathVariable Integer id ){

		return ResponseEntity.status(HttpStatus.OK).body("Invocou o PUT -> " + id);
	}

	@DeleteMapping ("/{id}")
	public ResponseEntity<Object> deleteTipo( @PathVariable Integer id ){

		return ResponseEntity.status(HttpStatus.OK).body("Invocou o DELETE -> " + id);
	}
}
