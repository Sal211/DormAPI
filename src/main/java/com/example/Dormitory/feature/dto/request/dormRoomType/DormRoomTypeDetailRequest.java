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
public class DormRoomTypeDetailRequest {
    @NotBlank(message = "RoomTypeId cannot be blank")
    @Min(value = 1, message = "The RoomTypeId must be greater than 0")
    Integer roomTypeId;

    int numberOfPage = 0;
    int size = 0;
}
