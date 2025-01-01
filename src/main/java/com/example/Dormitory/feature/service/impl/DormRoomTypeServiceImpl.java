package com.example.Dormitory.feature.service.impl;

import com.example.Dormitory.exceptions.BusinessException;
import com.example.Dormitory.feature.dto.request.dormRoomType.DormRoomTypeDetailRequest;
import com.example.Dormitory.feature.dto.request.dormRoomType.DormRoomTypeRequest;
import com.example.Dormitory.feature.dto.request.dormRoomType.DormRoomTypeUpdateRequest;
import com.example.Dormitory.feature.entity.DormRoomType;
import com.example.Dormitory.feature.repository.DormRoomTypeRepository;
import com.example.Dormitory.feature.repository.DormRoomsRepository;
import com.example.Dormitory.feature.service.DormRoomTypeService;
import com.example.Dormitory.feature.util.BaseResponse;
import com.example.Dormitory.feature.util.mapper.DormRoomTypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DormRoomTypeServiceImpl implements DormRoomTypeService {

    private final DormRoomTypeRepository dormRoomTypeRepository;
    private final DormRoomTypeMapper dormRoomTypeMapper;
    private final DormRoomsRepository dormRoomsRepository;

    @Override
    public BaseResponse<Void> createRoomType(DormRoomTypeRequest request) {
        BaseResponse<Void> response = new BaseResponse<>();
        // PREVENT DUPLICATE NAME
        boolean existRoomType = dormRoomTypeRepository.existsByRoomTypeName(request.getRoomTypeName());
        if(existRoomType) throw new BusinessException("Duplicate RoomType Name");

        // SAVE ROOM TYPE
        DormRoomType dormRoomType = dormRoomTypeMapper.toDormRoomType(request);
        dormRoomTypeRepository.save(dormRoomType);

        // RESPONSE
        response.isSuccess();
        return response;
    }

    @Override
    public BaseResponse<Void> updateRoomType(DormRoomTypeUpdateRequest request) {
        BaseResponse<Void> response = new BaseResponse<>();
        // PREVENT DUPLICATE NAME
        boolean existRoomType = dormRoomTypeRepository.existsByRoomTypeName(request.getRoomTypeName());
        if(existRoomType) throw new BusinessException("Duplicate RoomType Name");

        // FIND ROOM TYPE
        DormRoomType dormRoomType = dormRoomTypeRepository.findById(request.getRoomTypeId())
                .orElseThrow(() -> new BusinessException("RoomType Not Found"));

        dormRoomTypeMapper.copy(request,dormRoomType);
        dormRoomTypeRepository.save(dormRoomType);

        // RESPONSE
        response.isSuccess();
        return response;
    }

    @Override
    public BaseResponse<Void> deleteRoomType(DormRoomTypeDetailRequest request) {
        BaseResponse<Void> response = new BaseResponse<>();
        // FIND ROOM TYPE
        boolean existRoomType = dormRoomTypeRepository.existsById(request.getRoomTypeId());
        if (existRoomType) throw new BusinessException("RoomType not found");

        // PREVENT DELETE OCCUPY ROOM
        existRoomType = dormRoomsRepository.existsByRoomTypeId(request.getRoomTypeId());
        if (existRoomType) throw new BusinessException("RoomType is occupying,cannot delete");

        // DELETE ROOM TYPE
        dormRoomTypeRepository.deleteById(request.getRoomTypeId());

        // RESPONSE
        response.isSuccess();
        return response;
    }

    @Override
    public BaseResponse<List<DormRoomType>> getAllRoomType(DormRoomTypeDetailRequest request) {
        BaseResponse<List<DormRoomType>> response = new BaseResponse<>();
        List<DormRoomType> roomTypes;

        if(request.getSize() > 0 || request.getNumberOfPage() > 0){
            Pageable pageable = PageRequest.of(request.getNumberOfPage(), request.getSize());
            roomTypes = dormRoomTypeRepository.findAll(pageable).getContent();
        }else{
            roomTypes = dormRoomTypeRepository.findAll();
        }

        // RESPONSE
        response.setData(roomTypes);
        response.isSuccess();
        return response;
    }

    @Override
    public BaseResponse<DormRoomType> getRoomTypeById(DormRoomTypeDetailRequest request) {
        BaseResponse<DormRoomType> response = new BaseResponse<>();

        DormRoomType dormRoomType = dormRoomTypeRepository.findById(request.getRoomTypeId())
                .orElseThrow(() -> new BusinessException("RoomType Not Found"));

        response.isSuccess();
        response.setData(dormRoomType);
        return response;
    }

}
