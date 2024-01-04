package com.examination.project.infrastructure.persistance.exam.entities;

import com.examination.project.infrastructure.persistance.invigilator.entities.InvigilatorEntity;
import com.examination.project.infrastructure.persistance.student.entities.StudentEntity;
import com.examination.project.infrastructure.persistance.subject.entities.SubjectEntity;
import com.examination.project.infrastructure.persistance.room.entities.RoomEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;


@Data
@NoArgsConstructor
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "exams")
public class ExamEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 6958515320559275010L;

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int examId;

    @Column()
    @NonNull
    private String examName;

    @Column
    @NonNull
    private LocalDateTime examDate;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id", nullable = false)
    @NonNull
    @ToString.Exclude
    private SubjectEntity subject;

    @ManyToOne(optional = false)
    @JoinColumn(name = "room_id", nullable = false)
    @NonNull
    @ToString.Exclude
    private RoomEntity room;

    @ManyToOne(optional = false)
    @JoinColumn(name = "invigilator_id", nullable = false)
    @NonNull
    @ToString.Exclude
    private InvigilatorEntity invigilator;

    @ManyToMany(mappedBy = "examEntities")
    @Builder.Default
    @ToString.Exclude
    private Collection<StudentEntity> students = new HashSet<>();

//    public void setStudents(Collection<StudentEntity> students) {
//        this.students = students;
//    }
//
//    public void addStudent(StudentEntity studentEntity) {
//        this.students.add(studentEntity);
//        studentEntity.getExamEntities().add(this);
//    }

//    @Override
//    public String toString() {
//        return "ExamEntity{" +
//                "examId=" + examId +
//                ", examName='" + examName + '\'' +
//                ", examDate=" + examDate +
//                ", subject=" + subject +
//                ", room=" + room +
//                ", invigilator=" + invigilator +
//                '}';
//    }
}
