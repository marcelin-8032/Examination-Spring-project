package com.cegefos.tp1.persistance.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cegefos.tp1.persistance.entities.InvigilatorEntity;

@Repository
public interface InvigilatorRepository extends CrudRepository<InvigilatorEntity, Integer> {

}
