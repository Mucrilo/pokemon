package br.santos.murilo.pokemon.models.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PokemonDTO {
	private String nome;
	private Float altura;
	private Float peso;
	private Integer vida;
	private Integer ataque;
	private Integer defesa;
	private Integer ataqueSP;
	private Integer defesaSP;
	private Integer velocidade;
	private List<Integer> tipos;
	private List<Integer> habilidades;
	private List<Integer> fraquezas;
}
