package com.cegefos.tp2.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="surveillant")
public class Surveillant implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5461477499521864156L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer surveillantId;
	
	@Column
    private String nom;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "surveillant")
	private Set<Examen> examens=new HashSet<>();
	
	public Surveillant(String nom) {
		super();
		this.nom = nom;
		
	}

	@Override
	public String toString() {
		return "Surveillant{" +
				"surveillantId=" + surveillantId +
				", nom='" + nom + '\'' +
				'}';
	}
}
