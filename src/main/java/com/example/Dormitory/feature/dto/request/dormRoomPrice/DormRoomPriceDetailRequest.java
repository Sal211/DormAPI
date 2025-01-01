package com.example.Dormitory.feature.dto.request.dormRoomPrice;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DormRoomPriceDetailRequest {
    @NotBlank(message = "PriceId cannot be blank")
    @Min(value = 1, message = "The PriceId must be greater than 0")
    Integer priceId;

    int numberOfPage;
    int size;
}
