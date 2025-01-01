package com.example.Dormitory.feature.dto.request.dormRoomType;


import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DormRoomTypeRequest {

    Integer roomTypeId = 0;
    @NotBlank(message = "RoomTypeName cannot be blank")
    String roomTypeName;
    String description;
    Integer createUID;
}
