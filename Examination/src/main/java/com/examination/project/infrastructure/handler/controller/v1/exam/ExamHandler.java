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
@Tag(name = "Exam API", description = "Management APIs for Exam")
public interface ExamHandler {

    @Operation(summary = "Add an exam", description = "Return nothing")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema=@Schema(implementation = Exam.class)))
            }),
    })
    ResponseEntity<Void> addExam(Exam exam);

    @Operation(summary = "add a list of exams", description = "Return nothing")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema=@Schema(implementation = Exam.class)))
            }),
    })
    ResponseEntity<Void> createExams(List<Exam> exams);

    @Operation(summary = "find all exams", description = "Returns list of exams")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema=@Schema(implementation = Exam.class)))
            }),
            @ApiResponse(responseCode = "404", description = "Not Found Invigilator")
    })
    ResponseEntity<Collection<Exam>> getAllExams();

    @Operation(summary = "find exams by examDate", description = "Returns list of exams")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema=@Schema(implementation = Exam.class)))
            }),
            @ApiResponse(responseCode = "404", description = "Not Found Invigilator")
    })
    ResponseEntity<Collection<Exam>> getExamsByDate(LocalDateTime date);

    @Operation(summary = "find exams at a exam room and after a date", description = "Returns list of exams")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema=@Schema(implementation = Exam.class)))
            }),
            @ApiResponse(responseCode = "404", description = "Not Found Invigilator")
    })
    ResponseEntity<Collection<Exam>> getExamsAtRoomAndAfterADate(Integer roomId, LocalDateTime date);

    @Operation(summary = "find exams by thier room and order by date desc", description = "Returns list of exams")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema=@Schema(implementation = Exam.class)))
            }),
            @ApiResponse(responseCode = "404", description = "Not Found Invigilator")
    })
    ResponseEntity<Collection<Exam>> getExamsByRoomOrderByDate(Room room);

    @Operation(summary = "find all exams in a pge", description = "Returns page of exams")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema=@Schema(implementation = Exam.class)))
            }),
            @ApiResponse(responseCode = "404", description = "Not Found Invigilator")
    })
    ResponseEntity<Page<Exam>> getAllExamsInPages(Pageable pageable);

    @Operation(summary = "find exams by their room", description = "Returns page of exams")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema=@Schema(implementation = Exam.class)))
            }),
            @ApiResponse(responseCode = "404", description = "Not Found Invigilator")
    })
    ResponseEntity<Page<Exam>> getAllExamsByRoom(Integer roomId, Pageable pageable);

    @Operation(summary = "find exams of a student", description = "Returns list of exams")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema=@Schema(implementation = Exam.class)))
            }),
            @ApiResponse(responseCode = "404", description = "Not Found Invigilator")
    })
    ResponseEntity<Collection<Exam>> getExamsAssignedToSpecificStudent(Integer studentId);

    @Operation(summary = "delete all Exams", description = "Return nothing")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Exam.class))
            }),
    })
    ResponseEntity<Void> deleteAllExams();
}
