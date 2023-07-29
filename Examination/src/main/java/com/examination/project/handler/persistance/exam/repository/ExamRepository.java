package com.examination.project.handler.persistance.exam.repository;

import com.examination.project.entities.Room;
import com.examination.project.handler.persistance.exam.entities.ExamEntity;
import com.examination.project.handler.persistance.room.entities.RoomEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Repository
public interface ExamRepository extends CrudRepository<ExamEntity, Integer>,
        JpaSpecificationExecutor<ExamEntity> {

    List<ExamEntity> findAll();

    Collection<ExamEntity> findExamenByDateExam(LocalDateTime dateExam);

    Collection<ExamEntity> findByRoomAndDateExamGreaterThan(RoomEntity roomEntity, LocalDateTime dateExam);

    Collection<ExamEntity> findTopByRoomOrderByDateExamDesc(RoomEntity roomEntity);

    /********************************  -------------------------Query methods------------------***************/
    @Query(value = "SELECT * FROM examens e WHERE e.date_exam=:date_exam", nativeQuery = true)
    Collection<ExamEntity> findRoomsAsDateExamQuery(@Param("date_exam") LocalDateTime date_exam);

    @Query(value = "SELECT * FROM examens e INNER JOIN salle s ON  e.salle_id=s.salle_id " +
            " WHERE e.salle_id=:salle_id AND e.date_exam > :date_exam", nativeQuery = true)
    Collection<ExamEntity> findRoomAndDateExamQuery(@Param("salle_id") Integer salle_id, @Param("date_exam") LocalDateTime dateExam);

    @Query(value = "SELECT * FROM examens e INNER JOIN salle s ON e.salle_id=s.salle_id " +
            "WHERE e.salle_id=:salle_id ORDER BY date_exam DESC LIMIT 1", nativeQuery = true)
    Collection<ExamEntity> findExamsAtRecentDateQuery(@Param("salle_id") Integer salle_id);


    /********************************  -------------------------Pagination and sorting methods------------------***************/
    @Query(value = "SELECT * FROM examens", nativeQuery = true)
    Page<ExamEntity> findAllExams(Pageable pageable);

    @Query(value = "SELECT * FROM examens e WHERE e.surveillant_id=:surveillant_id",
            countQuery = "SELECT COUNT(*) FROM examens e WHERE e.surveillant_id=:surveillant_id", nativeQuery = true)
    Page<ExamEntity> findByInvigilator(@Param("surveillant_id") Integer surveillant_id, Pageable pageable);

    @Query(value = "SELECT * FROM exams e WHERE e.room_id=:room_id",
            countQuery = "SELECT COUNT(*) FROM exams e WHERE e.room_id=:room_id", nativeQuery = true)
    Page<ExamEntity> findByRoom(@Param("room_id") Integer room_id, Pageable pageable);

    Collection<ExamEntity> findExamsByRoomAndDate(Room room, LocalDateTime localDateTime);
}
