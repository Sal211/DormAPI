package com.example.Dormitory.feature.dto.request.dormRooms;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DormRoomsRequest {

    @NotBlank(message = "RoomTypeId cannot be blank")
    Integer roomTypeId;

    @NotBlank(message = "RoomName cannot be blank")
    String roomName;

    @NotBlank(message = "Floor cannot be blank")
    @Min(value = 0, message = "The floor must be equal or greater than 0")
    Integer floor;

    @NotBlank(message = "Capacity cannot be blank")
    @Min(value = 1, message = "The capacity must be greater than 0")
    Integer capacity;

    @NotBlank(message = "Bed cannot be blank")
    @Min(value = 1, message = "The bed must be greater than 0")
    Integer bed;

    String note;
    Integer createUID;
}
