package com.cegefos.tp1.repository;

import java.util.Collection;

import com.cegefos.tp1.annotation.ReadOnlyRepository;
import com.cegefos.tp1.entity.Surveillant;

@ReadOnlyRepository
public interface SurveillantReadOnlyRepository extends ReadOnlyBaseRepository<Surveillant, Integer> {

	Collection<Surveillant> findAllBySurveillantNom(String nom);

}
