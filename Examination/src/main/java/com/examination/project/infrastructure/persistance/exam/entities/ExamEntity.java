package com.examination.project.infrastructure.persistance.exam.entities;

import com.examination.project.infrastructure.persistance.invigilator.entities.InvigilatorEntity;
import com.examination.project.infrastructure.persistance.room.entities.RoomEntity;
import com.examination.project.infrastructure.persistance.student.entities.StudentEntity;
import com.examination.project.infrastructure.persistance.subject.entities.SubjectEntity;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
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
    private Instant examDate;

    @Column
    @CreatedDate
    private Instant createDate;

    @Column
    @CreatedBy
    private String createdBy;

    @Column
    @LastModifiedDate
    private Instant modifiedDate;

    @Column
    @LastModifiedBy
    private String modifiedBy;

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
