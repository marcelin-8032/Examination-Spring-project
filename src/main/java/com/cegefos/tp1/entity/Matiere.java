package com.cegefos.tp1.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cegefos.tp1.enums.Module;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "matiere")
public class Matiere implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6377054955014203603L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer matiereId;
	
	@Column
    private String intitule;
	
	@Column
	 private  int coefficient;
	
	@Enumerated(EnumType.STRING)
	@Column
	 private Module module;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "matiere")
	private Set<Examen> examens=new HashSet<>();
	
	public Matiere(String intitule, int coefficient, Module module) {
		super();
		this.intitule = intitule;
		this.coefficient = coefficient;
		this.module = module;
	}


	@Override
	public String toString() {
		return "Matiere{" +
				"matiereId=" + matiereId +
				", intitule='" + intitule + '\'' +
				", coefficient=" + coefficient +
				", module=" + module +
				'}';
	}
}
