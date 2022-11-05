package br.santos.murilo.pokemon.models.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "habilidades")
public class Habilidade {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false)
	private String habilidade;

	@JsonBackReference
	@ManyToMany
	@JoinTable (name = "tipos_pokemon", 
		joinColumns = @JoinColumn (name = "idTipo"),
		inverseJoinColumns = @JoinColumn (name = "idPokemon"))
	private List<Pokemon> pokemons;
}
