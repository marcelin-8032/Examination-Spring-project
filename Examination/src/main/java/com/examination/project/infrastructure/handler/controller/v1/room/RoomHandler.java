package com.examination.project.infrastructure.handler.controller.v1.room;

import com.examination.project.domain.entities.Room;
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

@Tag(name = " Rooms API", description = "Management APIs for Room")
public interface RoomHandler {

    @Operation(summary = "add room", description = "Return nothing")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Room.class))
            }),
    })
    ResponseEntity<Void> createARoom(Room room);

    @Operation(summary = "Update room number by roomId ", description = "Return nothing",
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation", content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Room.class)))
                    }),
                    @ApiResponse(responseCode = "400", description = "Invalid room number")
            }
    )
    ResponseEntity<Void> updateRoomNumber(Integer roomId, int number) throws Exception;

    @Operation(summary = "add two rooms", description = "Return nothing",
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation", content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Room.class)))
                    })
            }
    )
    ResponseEntity<Void> addSeveralRooms(List<Room> rooms);

    @Operation(summary = "Delete all rooms", description = "Return nothing",
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation", content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Room.class)))
                    })
            }
    )
    ResponseEntity<Void> deleteAllRooms();

    @Operation(summary = "fetch all rooms", description = "Return list of rooms",
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation", content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Room.class)))
                    })
            }
    )
    ResponseEntity<Collection<Room>> fetchAllRooms();
}
