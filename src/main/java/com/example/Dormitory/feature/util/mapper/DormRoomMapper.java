package com.example.Dormitory.feature.util.mapper;

import com.example.Dormitory.feature.dto.request.dormRooms.DormRoomUpdateRequest;
import com.example.Dormitory.feature.dto.request.dormRooms.DormRoomsRequest;
import com.example.Dormitory.feature.entity.DormRooms;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DormRoomMapper {
    DormRooms toDormRooms(DormRoomsRequest dormRoomsRequest);
    void copy(DormRoomUpdateRequest request, @MappingTarget DormRooms dormRoom);
}
