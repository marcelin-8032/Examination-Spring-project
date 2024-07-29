package com.examination.project.infrastructure.persistance.exam.repository;

import com.examination.project.domain.entities.Room;
import com.examination.project.infrastructure.persistance.exam.entities.ExamEntity;
import com.examination.project.infrastructure.persistance.room.entities.RoomEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Collection;

public interface ExamRepository extends JpaRepository<ExamEntity, Integer>,
        JpaSpecificationExecutor<ExamEntity> {

    Collection<ExamEntity> findByExamDate(Instant instant);

    Collection<ExamEntity> findByRoomAndExamDateGreaterThan(RoomEntity room, LocalDateTime examDate);

    Collection<ExamEntity> findByRoomOrderByExamDateDesc(RoomEntity room);

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

    @Query(value = "SELECT * FROM exams e WHERE e.invigilator_id=:invigilator_id",
            countQuery = "SELECT COUNT(*) FROM exams e WHERE e.invigilator_id=:invigilator_id", nativeQuery = true)
    Page<ExamEntity> findByInvigilatorId(@Param("invigilator_id") Integer invigilator_id, Pageable pageable);

    @Query(value = "SELECT * FROM exams e WHERE e.room_id=:room_id",
            countQuery = "SELECT COUNT(*) FROM exams e WHERE e.room_id=:room_id", nativeQuery = true)
    Page<ExamEntity> findByRoom(@Param("room_id") Integer room_id, Pageable pageable);

    Collection<ExamEntity> findByRoomAndExamDate(Room room, LocalDateTime examDate);

    @Query(value = "SELECT * FROM exams e INNER JOIN students_exams se ON e.exam_id=se.exam_entity_exam_id WHERE se.student_entity_student_id=:studentId",
            nativeQuery = true)
    Collection<ExamEntity> findExamsByStudentId(@Param("studentId") Integer studentId);
}
