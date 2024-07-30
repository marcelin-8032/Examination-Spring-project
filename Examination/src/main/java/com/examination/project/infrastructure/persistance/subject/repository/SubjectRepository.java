package com.examination.project.infrastructure.persistance.subject.repository;

import com.examination.project.infrastructure.persistance.subject.entities.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.Collection;


public interface SubjectRepository extends JpaRepository<SubjectEntity, Integer> ,
        QuerydslPredicateExecutor<SubjectEntity> {

    Collection<SubjectEntity> findByCoefficientGreaterThan(int coefficient);

    /********************************  -------------------------Query methods------------------***************/

    @Query(value = "SELECT * FROM matiere m WHERE m.coefficient > :coefficient", nativeQuery = true)
    Collection<SubjectEntity> findByCoefficient(@Param("coefficient") int coefficient);



}
