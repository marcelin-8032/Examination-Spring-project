package com.examination.project.infrastructure.persistance.invigilator.repository;

import java.util.Collection;


import com.examination.project.infrastructure.persistance.common.readonly.ReadOnlyRepository;
import com.examination.project.infrastructure.persistance.invigilator.entities.InvigilatorEntity;
import com.examination.project.infrastructure.persistance.common.readonly.ReadOnlyBaseRepository;

@ReadOnlyRepository
public interface InvigilatorReadOnlyRepository extends ReadOnlyBaseRepository<InvigilatorEntity, Integer> {

	Collection<InvigilatorEntity> findAllBySurveillantNom(String nom);

}
