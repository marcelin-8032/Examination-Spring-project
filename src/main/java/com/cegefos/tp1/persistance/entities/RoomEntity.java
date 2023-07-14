package com.cegefos.tp1.persistance.entities;

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

import lombok.*;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Builder(toBuilder = true)
@Table(name = "salle")
public class RoomEntity extends AuditableBaseEntity   {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer salleId;

	@Column
	@NonNull
	private int numero;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "salle")
	private Set<ExamEntity> examenEntities = new HashSet<>();

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

}
