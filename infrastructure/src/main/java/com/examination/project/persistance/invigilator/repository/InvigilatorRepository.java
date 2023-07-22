package com.examination.project.persistance.invigilator.repository;

import com.examination.project.persistance.invigilator.entities.InvigilatorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvigilatorRepository extends CrudRepository<InvigilatorEntity, Integer> {

}
