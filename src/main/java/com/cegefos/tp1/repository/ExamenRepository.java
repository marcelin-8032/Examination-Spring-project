package com.cegefos.tp1.repository;

import com.cegefos.tp1.entity.Salle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cegefos.tp1.entity.Examen;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface ExamenRepository extends CrudRepository<Examen, Integer> {

    List<Examen> findAll();

    Collection<Examen> findExamenByDateExam(Date dateExam);

    Collection<Examen> findBySalleAndDateExamGreaterThan(Salle salle, Date dateExam);

    Collection<Examen> findTopBySalleOrderByDateExamDesc(Salle salle);

    /********************************  -------------------------Query methods------------------***************/
    @Query(value = "SELECT * FROM examens e WHERE e.date_exam=:date_exam", nativeQuery = true)
    Collection<Examen> findExamensAsDateExamQuery(@Param("date_exam") Date date_exam);

    @Query(value = "SELECT * FROM examens e INNER JOIN salle s ON  e.salle_id=s.salle_id " +
            " WHERE e.salle_id=:salle_id AND e.date_exam > :date_exam", nativeQuery = true)
    Collection<Examen> findSalleAndDateExamQuery(@Param("salle_id") Integer salle_id, @Param("date_exam") Date dateExam);

    @Query(value = "SELECT * FROM examens e INNER JOIN salle s ON e.salle_id=s.salle_id " +
            "WHERE e.salle_id=:salle_id ORDER BY date_exam DESC LIMIT 1", nativeQuery = true)
    Collection<Examen> findExamensAtRecentDateQuery(@Param("salle_id") Integer salle_id);


    /********************************  -------------------------Pagination and sorting methods------------------***************/
    @Query(value = "SELECT * FROM examens", nativeQuery = true)
    Page<Examen> findAllExamens(Pageable pageable);


   @Query(value = "SELECT * FROM examens e WHERE e.surveillant_id=:surveillant_id",
           countQuery = "SELECT COUNT(*) FROM examens e WHERE e.surveillant_id=:surveillant_id", nativeQuery = true)
   Page<Examen> findBysurveillant(@Param("surveillant_id")Integer surveillant_id, Pageable pageable);


}
