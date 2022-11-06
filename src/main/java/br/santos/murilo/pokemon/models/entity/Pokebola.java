package br.santos.murilo.pokemon.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@Table (name = "pokebolas")
public class Pokebola {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String tipo;

	@ManyToOne
	@JoinColumn (name = "idTreinador")
	private Treinador treinador;

	@OneToOne
	@JoinColumn (name = "idPokemon")
	private Pokemon pokemon;
}
