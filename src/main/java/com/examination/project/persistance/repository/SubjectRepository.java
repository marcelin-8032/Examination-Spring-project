package com.examination.project.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.examination.project.persistance.entities.SubjectEntity;

import java.util.Collection;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity, Integer> , QuerydslPredicateExecutor<SubjectEntity> {

    Collection<SubjectEntity> findByCoefficientGreaterThan(int coefficient);

    /********************************  -------------------------Query methods------------------***************/

    @Query(value = "SELECT * FROM matiere m WHERE m.coefficient > :coefficient", nativeQuery = true)
    Collection<SubjectEntity> findByCoefficient(@Param("coefficient") int coefficient);



}
