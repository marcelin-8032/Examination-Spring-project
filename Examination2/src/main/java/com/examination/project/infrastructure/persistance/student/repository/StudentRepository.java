package com.examination.project.infrastructure.persistance.student.repository;


import com.examination.project.domain.entities.Classe;
import com.examination.project.infrastructure.persistance.student.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;


public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

    Collection<StudentEntity> findStudentsByClasse(Classe classe);

    /*****************************-------------------------Query methods------------------***************/

    @Query(value = "SELECT * FROM students e WHERE e.classe=:classe", nativeQuery = true)
    Collection<StudentEntity> findByClasse(@Param("classe") Classe classe);


}
