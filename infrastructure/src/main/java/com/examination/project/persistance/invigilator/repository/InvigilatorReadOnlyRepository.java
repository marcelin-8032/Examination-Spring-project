package com.examination.project.persistance.invigilator.repository;

import java.util.Collection;

import com.examination.project.annotation.ReadOnlyRepository;
import com.examination.project.persistance.invigilator.entities.InvigilatorEntity;
import com.examination.project.persistance.common.ReadOnlyBaseRepository;

@ReadOnlyRepository
public interface InvigilatorReadOnlyRepository extends ReadOnlyBaseRepository<InvigilatorEntity, Integer> {

	Collection<InvigilatorEntity> findAllBySurveillantNom(String nom);

}
