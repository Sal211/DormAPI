package com.example.Dormitory.feature.dto.request.bookingRoom;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingRoomUpdateRequest {
    Integer tranId;
    @NotBlank(message = "studentId cannot be blank")
    @Min(value = 1, message = "The FullPriceMonth must be greater than 0")
    Integer roomId;

    @NotBlank(message = "studentId cannot be blank")
    @Min(value = 1, message = "The studentId must be greater than 0")
    Long studentId;

    @NotBlank(message = "startDate cannot be blank")
    LocalDate startDate;

    LocalTime startTime;

    @NotBlank(message = "endDate cannot be blank")
    LocalDate endDate;

    LocalTime endTime;

    @NotBlank(message = "studentId cannot be blank")
    @Min(value = 1, message = "The studentId must be greater than 0")
    BigDecimal tuitionDue;

    @NotBlank(message = "tuitionPaid cannot be blank")
    @Min(value = 1, message = "The tuitionPaid must be greater than 0")
    BigDecimal tuitionPaid;

    @NotBlank(message = "tuitionFee cannot be blank")
    @Min(value = 1, message = "The tuitionFee must be greater than 0")
    BigDecimal tuitionFee;

    Integer tenantType = 0;
    double discount = 0;
    Boolean isPaid;
    Boolean cusType;
    Integer createUID;
}
