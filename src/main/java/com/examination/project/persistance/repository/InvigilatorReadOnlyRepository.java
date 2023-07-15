package com.examination.project.persistance.repository;

import java.util.Collection;

import com.examination.project.annotation.ReadOnlyRepository;
import com.examination.project.persistance.entities.InvigilatorEntity;

@ReadOnlyRepository
public interface InvigilatorReadOnlyRepository extends ReadOnlyBaseRepository<InvigilatorEntity, Integer> {

	Collection<InvigilatorEntity> findAllBySurveillantNom(String nom);

}
