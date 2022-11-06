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
		Habilidade novaHabilidade = new Habilidade();
		BeanUtils.copyProperties(habilidadeDTO, novaHabilidade);

		return ResponseEntity.status(HttpStatus.OK).body(habilidadeRepository.save(novaHabilidade));
	}

	@PutMapping ("/{id}")
	public ResponseEntity<Object> updateHabilidade( @PathVariable Integer id, @RequestBody HabilidadeDTO habilidadeDTO ){
		Optional<Habilidade> habilidadeExists = habilidadeRepository.findById(id);

		if (!habilidadeExists.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");
		}

		Habilidade atualizaHabiliade = habilidadeExists.get();

        BeanUtils.copyProperties(habilidadeDTO, atualizaHabiliade);
		
		return ResponseEntity.status(HttpStatus.OK).body(habilidadeRepository.save(atualizaHabiliade));
	}

	@DeleteMapping ("/{id}")
	public ResponseEntity<Object> deleteHabilidade( @PathVariable Integer id ){
		Optional<Habilidade> habilidadeExists = habilidadeRepository.findById(id);
		
		if (!habilidadeExists.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");
		}

		habilidadeRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Habilidade excluída com sucesso");
	}
}
