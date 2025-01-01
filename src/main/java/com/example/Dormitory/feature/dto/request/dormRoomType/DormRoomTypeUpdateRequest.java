package com.example.Dormitory.feature.dto.request.dormRoomType;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DormRoomTypeUpdateRequest {

    @NotBlank(message = "RoomTypeId cannot be blank")
    @Min(value = 1, message = "The RoomTypeId must be greater than 0")
    Integer roomTypeId;

    @NotBlank(message = "RoomTypeName cannot be blank")
    String roomTypeName;

    String description;
    Integer createUID;
}