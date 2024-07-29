package com.examination.project.infrastructure.handler.controller.v1.exam;

import com.examination.project.domain.entities.Exam;
import com.examination.project.domain.entities.Room;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
public interface ExamHandler {

    @Tag(name = "Exam API", description = "adding list of exams")
    @Operation(summary = "add Exams", description = "Return nothing")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Exam.class))
            }),
    })
    ResponseEntity<Void> createExams(List<Exam> exams);

    @Tag(name = "Exam API", description = "find all exams")
    @Operation(summary = "find all exams", description = "Returns list of exams")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema=@Schema(implementation = Exam.class)))
            }),
            @ApiResponse(responseCode = "404", description = "Not Found Invigilator")
    })
    ResponseEntity<Collection<Exam>> getAllExams();

    ResponseEntity<Collection<Exam>> getExamsByDate(LocalDateTime date);

    ResponseEntity<Collection<Exam>> getExamsAtRoomAndAfterADate(Integer roomId, LocalDateTime date);

    ResponseEntity<Collection<Exam>> getExamsAtRecentDataAtSpecificRoom(Room room);

    ResponseEntity<Page<Exam>> getAllExamsInPages(Pageable pageable);

    ResponseEntity<Page<Exam>> getAllExamsByRoom(Integer roomId, Pageable pageable);

    ResponseEntity<Void> addExam(Exam exam);

    ResponseEntity<Collection<Exam>> getExamsAssignedToSpecificStudent(Integer studentId);

    @Tag(name = "Exam API", description = "delete all exams")
    @Operation(summary = "delete all Exams", description = "Return http code 200")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Exam.class))
            }),
    })
    ResponseEntity<Void> deleteAllExams();
}
