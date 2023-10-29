package com.examination.project.infrastructure.persistance.invigilator.repository;

import com.examination.project.infrastructure.persistance.invigilator.entities.InvigilatorEntity;
import org.springframework.data.repository.CrudRepository;


public interface InvigilatorRepository extends CrudRepository<InvigilatorEntity, Integer> {

}
