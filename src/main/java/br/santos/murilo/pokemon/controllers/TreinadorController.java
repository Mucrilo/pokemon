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

import br.santos.murilo.pokemon.models.dto.TreinadorDTO;
import br.santos.murilo.pokemon.models.entity.Treinador;
import br.santos.murilo.pokemon.models.repository.TreinadorRepository;

@RestController
@RequestMapping("/treinador")
public class TreinadorController {

	@Autowired
	TreinadorRepository treinadorRepository;
	
	@GetMapping
	public ResponseEntity<Object> getAllTreinadores(){

		return ResponseEntity.status(HttpStatus.OK).body(treinadorRepository.findAll());
	}

	@PostMapping
	public ResponseEntity<Object> saveTreinador(@RequestBody TreinadorDTO treinadorDTO){
		Treinador novoTreinador = new Treinador();
		BeanUtils.copyProperties(treinadorDTO, novoTreinador);

		return ResponseEntity.status(HttpStatus.OK).body(treinadorRepository.save(novoTreinador));
	}

	@PutMapping ("/{id}")
	public ResponseEntity<Object> updateTreinador( @PathVariable Integer id, @RequestBody TreinadorDTO treinadorDTO ){
		Optional<Treinador> treinadorExists = treinadorRepository.findById(id);
		
		if (!treinadorExists.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");
		}

		Treinador atualizaTreinador = treinadorExists.get();

		BeanUtils.copyProperties(treinadorDTO, atualizaTreinador);

        return ResponseEntity.status(HttpStatus.OK).body(treinadorRepository.save(atualizaTreinador));
	}

	@DeleteMapping ("/{id}")
	public ResponseEntity<Object> deleteTreinador( @PathVariable Integer id ){
		Optional<Treinador> treinadorExists = treinadorRepository.findById(id);
		
		if (!treinadorExists.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");
		}

		treinadorRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Treinador excluído com sucesso");
	}
}
