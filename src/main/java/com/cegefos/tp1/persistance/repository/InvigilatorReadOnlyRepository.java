package com.cegefos.tp1.persistance.repository;

import java.util.Collection;

import com.cegefos.tp1.annotation.ReadOnlyRepository;
import com.cegefos.tp1.persistance.entities.InvigilatorEntity;

@ReadOnlyRepository
public interface InvigilatorReadOnlyRepository extends ReadOnlyBaseRepository<InvigilatorEntity, Integer> {

	Collection<InvigilatorEntity> findAllBySurveillantNom(String nom);

}
