package com.example.Dormitory.feature.service;

import com.example.Dormitory.feature.dto.request.dormRoomType.DormRoomTypeDetailRequest;
import com.example.Dormitory.feature.dto.request.dormRoomType.DormRoomTypeRequest;
import com.example.Dormitory.feature.dto.request.dormRoomType.DormRoomTypeUpdateRequest;
import com.example.Dormitory.feature.entity.DormRoomType;
import com.example.Dormitory.feature.util.BaseResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DormRoomTypeService {
    BaseResponse<Void> createRoomType(DormRoomTypeRequest request);
    BaseResponse<Void> updateRoomType(DormRoomTypeUpdateRequest request);
    BaseResponse<Void> deleteRoomType(DormRoomTypeDetailRequest request);
    BaseResponse<List<DormRoomType>> getAllRoomType(DormRoomTypeDetailRequest request);
    BaseResponse<DormRoomType> getRoomTypeById(DormRoomTypeDetailRequest request);
}
