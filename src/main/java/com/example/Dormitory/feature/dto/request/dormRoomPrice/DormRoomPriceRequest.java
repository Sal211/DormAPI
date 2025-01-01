package com.example.Dormitory.feature.dto.request.dormRoomPrice;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DormRoomPriceRequest {
    @NotBlank(message = "RoomId cannot be blank")
    @Min(value = 1, message = "The RoomId must be greater than 0")
    Integer roomId;

    @NotBlank(message = "FullPriceMonth cannot be blank")
    @Min(value = 1, message = "The FullPriceMonth must be greater than 0")
    BigDecimal fullPriceMonth;

    @NotBlank(message = "FullPriceDay cannot be blank")
    @Min(value = 1, message = "The FullPriceDay must be greater than 0")
    BigDecimal fullPriceDay;

    @NotBlank(message = "PricePerMonth cannot be blank")
    @Min(value = 1, message = "The PricePerMonth must be greater than 0")
    BigDecimal pricePerMonth;

    @NotBlank(message = "PricePerDay cannot be blank")
    @Min(value = 1, message = "The PricePerDay must be greater than 0")
    BigDecimal pricePerDay;
    Integer createUID;
}
