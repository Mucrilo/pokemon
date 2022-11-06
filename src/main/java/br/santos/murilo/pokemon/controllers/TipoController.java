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
		Tipo novoTipo = new Tipo();
		BeanUtils.copyProperties(tipoDTO, novoTipo);

		return ResponseEntity.status(HttpStatus.OK).body(tipoRepository.save(novoTipo));
	}

	@PutMapping ("/{id}")
	public ResponseEntity<Object> updateTipo( @PathVariable Integer id, @RequestBody TipoDTO tipoDTO ){
		Optional<Tipo> tipoExists = tipoRepository.findById(id);

		if (!tipoExists.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");
		}

		Tipo atualizaTipo = tipoExists.get();
		
        BeanUtils.copyProperties(tipoDTO, atualizaTipo);

		return ResponseEntity.status(HttpStatus.OK).body(tipoRepository.save(atualizaTipo));
	}

	@DeleteMapping ("/{id}")
	public ResponseEntity<Object> deleteTipo( @PathVariable Integer id ){
		Optional<Tipo> tipoExists = tipoRepository.findById(id);
		
		if (!tipoExists.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");
		}

		tipoRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Tipo excluído com sucesso");
	}
}
