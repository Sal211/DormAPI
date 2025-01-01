package com.example.Dormitory.feature.util.mapper;

import com.example.Dormitory.feature.dto.request.dormRoomPrice.DormRoomPriceDetailRequest;
import com.example.Dormitory.feature.dto.request.dormRoomPrice.DormRoomPriceRequest;
import com.example.Dormitory.feature.dto.request.dormRoomPrice.DormRoomPriceUpdateRequest;
import com.example.Dormitory.feature.entity.DormRoomPrice;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DormRoomPriceMapper {
    DormRoomPrice toDormRoomPrice(DormRoomPriceRequest request);
    void copy(DormRoomPriceUpdateRequest request, @MappingTarget DormRoomPrice dormRoomPrice);
}
