package com.examination.project.persistance.entities;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.examination.project.audit.AuditableBaseEntity;

import io.vavr.collection.HashSet;
import lombok.*;


@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Builder(toBuilder = true)
@Table(name = "salle")
public class RoomEntity extends AuditableBaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer salleId;

	@Column
	@NonNull
	private int numero;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "salle")
	private HashSet<ExamEntity> examenEntities=HashSet.empty();

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
