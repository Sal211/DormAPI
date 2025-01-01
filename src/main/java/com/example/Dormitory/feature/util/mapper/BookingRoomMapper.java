package com.example.Dormitory.feature.util.mapper;

import com.example.Dormitory.feature.dto.request.bookingRoom.BookingRoomRequest;
import com.example.Dormitory.feature.dto.request.bookingRoom.BookingRoomUpdateRequest;
import com.example.Dormitory.feature.entity.BookingRoomTrans;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookingRoomMapper {
    BookingRoomTrans toBookingRoom(BookingRoomRequest request);
    void copy(BookingRoomUpdateRequest request, @MappingTarget BookingRoomTrans bookingRoomTrans);
}
