package com.cegefos.tp2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cegefos.tp2.entity.Surveillant;

@Repository
public interface SurveillantRepository extends CrudRepository<Surveillant, Integer> {

}
