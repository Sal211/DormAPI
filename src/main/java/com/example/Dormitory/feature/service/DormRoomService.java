package com.example.Dormitory.feature.service;

import com.example.Dormitory.feature.dto.request.dormRooms.DormRoomUpdateRequest;
import com.example.Dormitory.feature.dto.request.dormRooms.DormRoomsDetailRequest;
import com.example.Dormitory.feature.dto.request.dormRooms.DormRoomsRequest;
import com.example.Dormitory.feature.entity.DormRoomType;
import com.example.Dormitory.feature.entity.DormRooms;
import com.example.Dormitory.feature.util.BaseResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DormRoomService {
    BaseResponse<Void> createRoom(DormRoomsRequest request);
    BaseResponse<Void> updateRoom(DormRoomUpdateRequest request);
    BaseResponse<Void> deleteRoom(DormRoomsDetailRequest request);
    BaseResponse<List<DormRooms>> getAllRoom(DormRoomsDetailRequest request);
    BaseResponse<DormRooms> getRoomById(DormRoomsDetailRequest request);
}
