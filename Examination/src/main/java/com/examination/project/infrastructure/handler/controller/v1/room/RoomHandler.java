package com.examination.project.infrastructure.handler.controller.v1.room;

import com.examination.project.domain.entities.Room;
import com.examination.project.domain.entities.Student;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.List;

public interface RoomHandler {

    @Tag(name = " Rooms API", description = "adding room")
    @Operation(summary = "add room", description = "Returns a room")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Room.class))
            }),
    })
    ResponseEntity<Void> createARoom(Room room);

    @Tag(name = " Rooms API", description = "update room with number")
    @Operation(
            summary = "Update rooms by salle Id",
            description = "Update the room",
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation", content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Room.class)))
                    }),
                    @ApiResponse(responseCode = "400", description = "Invalid room number")
            }
    )
    ResponseEntity<Void> updateRoomWithNumber( Integer roomId, int number) throws Exception;

    @Tag(name = " Rooms API", description = "add two rooms")
    @Operation(
            summary = "add two rooms",
            description = "add two rooms",
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation", content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Room.class)))
                    })
            }
    )
    ResponseEntity<Void> createTwoRoom( List<Room> rooms);


    @Tag(name = " Rooms API", description = "delete all rooms")
    @Operation(
            summary = "Delete all rooms",
            description = "Delete all rooms",
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation", content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Room.class)))
                    })
            }
    )
    ResponseEntity<Void> deleteAllRooms();

    @Tag(name = " Rooms API", description = "fetch all rooms")
    @Operation(
            summary = "fetch all rooms",
            description = "fetch all rooms",
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation", content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Room.class)))
                    })
            }
    )
    ResponseEntity<Collection<Room>> fetchAllRooms();

}
