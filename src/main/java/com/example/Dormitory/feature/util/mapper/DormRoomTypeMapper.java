package com.example.Dormitory.feature.util.mapper;

import com.example.Dormitory.feature.dto.request.dormRoomType.DormRoomTypeRequest;
import com.example.Dormitory.feature.dto.request.dormRoomType.DormRoomTypeUpdateRequest;
import com.example.Dormitory.feature.entity.DormRoomType;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface DormRoomTypeMapper {
    DormRoomType toDormRoomType(DormRoomTypeRequest request);
    void copy(DormRoomTypeUpdateRequest request, @MappingTarget DormRoomType dormRoomType);
}
