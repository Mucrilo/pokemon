package br.santos.murilo.pokemon.models.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private Float altura;

	@Column(nullable = false)
	private Float peso;

	@Column(nullable = false)
	private Integer vida;

	@Column(nullable = false)
	private Integer ataque;

	@Column(nullable = false)
	private Integer defesa;

	@Column(nullable = false)
	private Integer ataqueSP;

	@Column(nullable = false)
	private Integer defesaSP;

	@Column(nullable = false)
	private Integer velocidade;

	@JsonManagedReference
	@ManyToMany (mappedBy = "pokemons", fetch = FetchType.LAZY)
	private List<Tipo> tipos = new ArrayList<Tipo>();

	@JsonManagedReference
	@ManyToMany (mappedBy = "pokemons", fetch = FetchType.LAZY)
	private List<Habilidade> habilidades = new ArrayList<Habilidade>();

	@JsonManagedReference
	@ManyToMany (mappedBy = "pokemons", fetch = FetchType.LAZY)
	private List<Fraqueza> fraquezas = new ArrayList<Fraqueza>();
}
