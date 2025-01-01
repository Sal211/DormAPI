package com.example.Dormitory.feature.service.impl;

import com.example.Dormitory.exceptions.BusinessException;
import com.example.Dormitory.feature.dto.request.dormRoomPrice.DormRoomPriceDetailRequest;
import com.example.Dormitory.feature.dto.request.dormRoomPrice.DormRoomPriceRequest;
import com.example.Dormitory.feature.dto.request.dormRoomPrice.DormRoomPriceUpdateRequest;
import com.example.Dormitory.feature.entity.DormRoomPrice;
import com.example.Dormitory.feature.repository.DormRoomPriceRepository;
import com.example.Dormitory.feature.service.DormRoomPriceService;
import com.example.Dormitory.feature.util.BaseResponse;
import com.example.Dormitory.feature.util.mapper.DormRoomPriceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DormRoomPriceServiceImpl implements DormRoomPriceService {

    private final DormRoomPriceRepository dormRoomPriceRepository;
    private final DormRoomPriceMapper dormRoomPriceMapper;

    @Override
    public BaseResponse<Void> createRoom(DormRoomPriceRequest request) {
        BaseResponse<Void> response = new BaseResponse<>();

        // SAVE ROOM
        DormRoomPrice dormRoom = dormRoomPriceMapper.toDormRoomPrice(request);
        dormRoomPriceRepository.save(dormRoom);

        // RESPONSE
        response.isSuccess();
        return response;
    }

    @Override
    public BaseResponse<Void> updateRoom(DormRoomPriceUpdateRequest request) {
        BaseResponse<Void> response = new BaseResponse<>();

        // FIND ROOM TYPE
        DormRoomPrice dormRoom = dormRoomPriceRepository.findById(request.getPriceId())
                .orElseThrow(() -> new BusinessException("Room Not Found"));

        dormRoomPriceMapper.copy(request,dormRoom);
        dormRoomPriceRepository.save(dormRoom);

        // RESPONSE
        response.isSuccess();
        return response;
    }

    @Override
    public BaseResponse<Void> deleteRoom(DormRoomPriceDetailRequest request) {
        BaseResponse<Void> response = new BaseResponse<>();
        // FIND ROOM TYPE
        boolean existRoom = dormRoomPriceRepository.existsById(request.getPriceId());
        if (existRoom) throw new BusinessException("Room not found");

        // PREVENT DELETE OCCUPY ROOM
        existRoom = dormRoomPriceRepository.existsByRoomId(request.getPriceId());
        if (existRoom) throw new BusinessException("Room is occupying,cannot delete");

        // DELETE ROOM TYPE
        dormRoomPriceRepository.deleteById(request.getPriceId());

        // RESPONSE
        response.isSuccess();
        return response;
    }

    @Override
    public BaseResponse<List<DormRoomPrice>> getAllRoom(DormRoomPriceDetailRequest request) {
        BaseResponse<List<DormRoomPrice>> response = new BaseResponse<>();
        List<DormRoomPrice> rooms;

        if(request.getSize() > 0 && request.getNumberOfPage() > 0){
            Pageable pageable = PageRequest.of(request.getNumberOfPage(), request.getSize());
            rooms = dormRoomPriceRepository.findAll(pageable).getContent();
        }else{
            rooms = dormRoomPriceRepository.findAll();
        }

        // RESPONSE
        response.setData(rooms);
        response.isSuccess();
        return response;
    }

    @Override
    public BaseResponse<DormRoomPrice> getRoomById(DormRoomPriceDetailRequest request) {
        BaseResponse<DormRoomPrice> response = new BaseResponse<>();
        // FIND ROOM
        DormRoomPrice dormRooms = dormRoomPriceRepository.findById(request.getPriceId())
                .orElseThrow(() -> new BusinessException("Room Not Found"));

        // RESPONSE
        response.isSuccess();
        response.setData(dormRooms);
        return response;
    }
}
