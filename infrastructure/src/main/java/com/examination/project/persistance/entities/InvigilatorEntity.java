package com.examination.project.persistance.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import io.vavr.collection.HashSet;
import io.vavr.collection.Set;
import lombok.*;


@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Builder(toBuilder = true)
@Table(name="surveillant")
public class InvigilatorEntity implements Serializable{

	private static final long serialVersionUID = -5461477499521864156L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer surveillantId;
	
	@Column
	@NonNull
    private String nom;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "surveillant")
	private Set<ExamEntity> examenEntities= HashSet.empty();

}
