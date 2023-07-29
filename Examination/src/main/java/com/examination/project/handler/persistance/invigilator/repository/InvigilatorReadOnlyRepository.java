package com.examination.project.handler.persistance.invigilator.repository;

import java.util.Collection;


import com.examination.project.handler.persistance.common.readonly.ReadOnlyRepository;
import com.examination.project.handler.persistance.invigilator.entities.InvigilatorEntity;
import com.examination.project.handler.persistance.common.readonly.ReadOnlyBaseRepository;

@ReadOnlyRepository
public interface InvigilatorReadOnlyRepository extends ReadOnlyBaseRepository<InvigilatorEntity, Integer> {

	Collection<InvigilatorEntity> findAllBySurveillantNom(String nom);

}
