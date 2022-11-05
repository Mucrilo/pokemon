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

import br.santos.murilo.pokemon.models.dto.HabilidadeDTO;
import br.santos.murilo.pokemon.models.entity.Habilidade;
import br.santos.murilo.pokemon.models.repository.HabilidadeRepository;

@RestController
@RequestMapping("/habilidade")
public class HabilidadeController {

	@Autowired
	HabilidadeRepository habilidadeRepository;
	
	@GetMapping
	public ResponseEntity<Object> getAllHabilidades(){

		return ResponseEntity.status(HttpStatus.OK).body(habilidadeRepository.findAll());
	}

	@PostMapping
	public ResponseEntity<Object> saveHabilidade(@RequestBody HabilidadeDTO habilidadeDTO){
		Habilidade habilidadeEntity = new Habilidade();
		BeanUtils.copyProperties(habilidadeDTO, habilidadeEntity);

		return ResponseEntity.status(HttpStatus.OK).body(habilidadeRepository.save(habilidadeEntity));
	}

	@PutMapping ("/{id}")
	public ResponseEntity<Object> updateHabilidade( @PathVariable Integer id ){

		return ResponseEntity.status(HttpStatus.OK).body("Invocou o PUT -> " + id);
	}

	@DeleteMapping ("/{id}")
	public ResponseEntity<Object> deleteHabilidade( @PathVariable Integer id ){

		return ResponseEntity.status(HttpStatus.OK).body("Invocou o DELETE -> " + id);
	}
}
