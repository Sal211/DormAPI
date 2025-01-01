package com.example.Dormitory.feature.service;

import com.example.Dormitory.feature.dto.request.dormRoomPrice.DormRoomPriceDetailRequest;
import com.example.Dormitory.feature.dto.request.dormRoomPrice.DormRoomPriceRequest;
import com.example.Dormitory.feature.dto.request.dormRoomPrice.DormRoomPriceUpdateRequest;
import com.example.Dormitory.feature.entity.DormRoomPrice;
import com.example.Dormitory.feature.util.BaseResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DormRoomPriceService {
    BaseResponse<Void> createRoom(DormRoomPriceRequest request);
    BaseResponse<Void> updateRoom(DormRoomPriceUpdateRequest request);
    BaseResponse<Void> deleteRoom(DormRoomPriceDetailRequest request);
    BaseResponse<List<DormRoomPrice>> getAllRoom(DormRoomPriceDetailRequest request);
    BaseResponse<DormRoomPrice> getRoomById(DormRoomPriceDetailRequest request);
}
