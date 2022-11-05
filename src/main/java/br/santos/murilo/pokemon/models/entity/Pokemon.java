package br.santos.murilo.pokemon.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "pokemons")
public class Pokemon {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer id;
	private String nome;
	private Float altura;
	private Float peso;

}
