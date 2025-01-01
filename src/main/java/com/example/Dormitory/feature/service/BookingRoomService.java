package com.example.Dormitory.feature.service;

import com.example.Dormitory.feature.dto.request.bookingRoom.BookingRoomDetailRequest;
import com.example.Dormitory.feature.dto.request.bookingRoom.BookingRoomRequest;
import com.example.Dormitory.feature.dto.request.bookingRoom.BookingRoomUpdateRequest;
import com.example.Dormitory.feature.dto.request.dormRoomPrice.DormRoomPriceDetailRequest;
import com.example.Dormitory.feature.dto.request.dormRoomPrice.DormRoomPriceRequest;
import com.example.Dormitory.feature.dto.request.dormRoomPrice.DormRoomPriceUpdateRequest;
import com.example.Dormitory.feature.entity.BookingRoomTrans;
import com.example.Dormitory.feature.entity.DormRoomPrice;
import com.example.Dormitory.feature.util.BaseResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingRoomService {
    BaseResponse<Void> createRoom(BookingRoomRequest request);
    BaseResponse<Void> updateRoom(BookingRoomUpdateRequest request);
    BaseResponse<Void> deleteRoom(BookingRoomDetailRequest request);
    BaseResponse<List<BookingRoomTrans>> getAllRoom(BookingRoomDetailRequest request);
    BaseResponse<BookingRoomTrans> getRoomById(BookingRoomDetailRequest request);
}
