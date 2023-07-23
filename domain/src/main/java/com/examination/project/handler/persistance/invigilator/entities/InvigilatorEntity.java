package com.examination.project.handler.persistance.invigilator.entities;

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


import com.examination.project.handler.persistance.exam.entities.ExamEntity;
import lombok.*;


@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Builder(toBuilder = true)
@Table(name="invigilator")
public class InvigilatorEntity implements Serializable{

	private static final long serialVersionUID = -5461477499521864156L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer invigilatorId;
	
	@Column
	@NonNull
    private String nom;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "invigilator")
	private Set<ExamEntity> examenEntities= new HashSet<>();

}
