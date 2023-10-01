package com.examination.project.infrastructure.persistance.student.repository;


import com.examination.project.domain.entities.Classe;
import com.examination.project.infrastructure.persistance.exam.entities.ExamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.examination.project.infrastructure.persistance.student.entities.StudentEntity;

import java.util.Collection;


@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

    Collection<StudentEntity> findStudentsByClasse(Classe classe);

    /*****************************-------------------------Query methods------------------***************/

    @Query(value = "SELECT * FROM etudiants e WHERE e.classe=:classe", nativeQuery = true)
    Collection<ExamEntity> findStudentsAsClasse(@Param("classe") Classe classe);


}
