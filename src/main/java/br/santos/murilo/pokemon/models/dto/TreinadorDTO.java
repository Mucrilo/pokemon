package br.santos.murilo.pokemon.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TreinadorDTO {
	private String nome;
	private Integer xp;
}
