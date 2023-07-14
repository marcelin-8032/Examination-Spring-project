package com.cegefos.tp1.persistance.entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "examens")
public class ExamEntity implements Serializable {

    private static final long serialVersionUID = 6958515320559275010L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer examenId;

    @Column
    @NonNull
    private Date dateExam;

    @ManyToMany(mappedBy = "examens")
    @NonNull
    private Set<StudentEntity> etudiantEntities = new HashSet<>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "matiere_id")
    @NonNull
    private SubjectEntity subjectEntity;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "salle_id")
    @NonNull
    private RoomEntity roomEntity;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "surveillant_id")
    @NonNull
    private InvigilatorEntity invigilatorEntity;

}
