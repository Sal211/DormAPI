package com.example.Dormitory.feature.dto.request.bookingRoom;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingRoomDetailRequest {
    @NotBlank(message = "TranId cannot be blank")
    @Min(value = 1, message = "The TranId must be greater than 0")
    Integer tranId;
    int numberOfPage;
    int size;
}
