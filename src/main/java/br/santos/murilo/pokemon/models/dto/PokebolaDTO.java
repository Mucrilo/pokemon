package br.santos.murilo.pokemon.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PokebolaDTO {
	private String tipo;
	private Integer idTreinador;
	private Integer idPokemon;
}
