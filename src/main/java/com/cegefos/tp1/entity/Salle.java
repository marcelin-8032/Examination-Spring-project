package com.cegefos.tp1.entity;

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


import com.cegefos.tp1.audit.AuditableBaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "salle")
public class Salle extends AuditableBaseEntity   {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer salleId;

	@Column
	private int numero;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "salle")
	private Set<Examen> examens = new HashSet<>();

	// Audit by annotation
	/*
	 * @CreatedBy
	 * 
	 * @Column private User createdBy;
	 * 
	 * @CreatedDate
	 * 
	 * @Column private ZonedDateTime createdAt;
	 * 
	 * @LastModifiedBy
	 * 
	 * @Column private User updatedBy;
	 * 
	 * @LastModifiedDate
	 * 
	 * @Column private ZonedDateTime updatedAt;
	 */

	public Salle(int numero) {
		super();
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Salle [numero=" + numero + "]";
	}

	

}
