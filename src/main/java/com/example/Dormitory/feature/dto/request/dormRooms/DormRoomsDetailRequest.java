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
public class DormRoomsDetailRequest {
    @NotBlank(message = "RoomTypeId cannot be blank")
    @Min(value = 1, message = "The RoomId must be greater than 0")
    Integer roomId;

    int numberOfPage;
    int size;
}
