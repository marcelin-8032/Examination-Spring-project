package com.cegefos.tp1.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "salle")
public class Salle implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -1006027224911791265L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer salleId;

	@Column
	private int numero;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "salle")
	private Set<Examen> examens = new HashSet<>();

	public Salle(int numero) {
		super();
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Salle{" + "salleId=" + salleId + ", numero=" + numero + '}';
	}
}
