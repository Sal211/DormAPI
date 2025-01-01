package com.example.Dormitory.feature.service.impl;

import com.example.Dormitory.exceptions.BusinessException;
import com.example.Dormitory.feature.dto.request.dormRooms.DormRoomUpdateRequest;
import com.example.Dormitory.feature.dto.request.dormRooms.DormRoomsDetailRequest;
import com.example.Dormitory.feature.dto.request.dormRooms.DormRoomsRequest;
import com.example.Dormitory.feature.entity.DormRooms;
import com.example.Dormitory.feature.repository.BookingRoomTransRepository;
import com.example.Dormitory.feature.repository.DormRoomPriceRepository;
import com.example.Dormitory.feature.repository.DormRoomsRepository;
import com.example.Dormitory.feature.service.DormRoomService;
import com.example.Dormitory.feature.util.BaseResponse;
import com.example.Dormitory.feature.util.mapper.DormRoomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DormRoomServiceImpl implements DormRoomService {
    private final DormRoomsRepository dormRoomsRepository;
    private final DormRoomPriceRepository dormRoomPriceRepository;
    private final DormRoomMapper dormRoomMapper;
    private final BookingRoomTransRepository bookingRoomTransRepository;

    @Override
    public BaseResponse<Void> createRoom(DormRoomsRequest request) {
        BaseResponse<Void> response = new BaseResponse<>();

        // PREVENT DUPLICATE NAME
        boolean existRoomType = dormRoomsRepository.existsByRoomName(request.getRoomName());
        if(existRoomType) throw new BusinessException("Duplicate Room Name");

        // SAVE ROOM
        DormRooms dormRoom = dormRoomMapper.toDormRooms(request);
        dormRoomsRepository.save(dormRoom);

        // RESPONSE
        response.isSuccess();
        return response;
    }

    @Override
    public BaseResponse<Void> updateRoom(DormRoomUpdateRequest request) {
        BaseResponse<Void> response = new BaseResponse<>();

        // FIND ROOM TYPE
        DormRooms dormRoom = dormRoomsRepository.findById(request.getRoomTypeId())
                .orElseThrow(() -> new BusinessException("Room Not Found"));

        // VALIDATE
        int totalTenant = bookingRoomTransRepository.totalTenant(request.getRoomId());
        if(totalTenant<request.getCapacity()) throw new BusinessException("Room Capacity cannot less than total tenant");

        dormRoomMapper.copy(request,dormRoom);
        dormRoomsRepository.save(dormRoom);

        // RESPONSE
        response.isSuccess();
        return response;
    }

    @Override
    public BaseResponse<Void> deleteRoom(DormRoomsDetailRequest request) {
        BaseResponse<Void> response = new BaseResponse<>();
        // FIND ROOM TYPE
        boolean existRoom = dormRoomsRepository.existsById(request.getRoomId());
        if (existRoom) throw new BusinessException("Room not found");

        // PREVENT DELETE OCCUPY ROOM
        existRoom = dormRoomPriceRepository.existsByRoomId(request.getRoomId());
        if (existRoom) throw new BusinessException("Room is occupying,cannot delete");

        // DELETE ROOM TYPE
        dormRoomsRepository.deleteById(request.getRoomId());

        // RESPONSE
        response.isSuccess();
        return response;
    }

    @Override
    public BaseResponse<List<DormRooms>> getAllRoom(DormRoomsDetailRequest request) {
        BaseResponse<List<DormRooms>> response = new BaseResponse<>();
        List<DormRooms> rooms;

        if(request.getSize() > 0 && request.getNumberOfPage() > 0){
            Pageable pageable = PageRequest.of(request.getNumberOfPage(), request.getSize());
            rooms = dormRoomsRepository.findAll(pageable).getContent();
        }else{
            rooms = dormRoomsRepository.findAll();
        }

        // RESPONSE
        response.setData(rooms);
        response.isSuccess();
        return response;
    }

    @Override
    public BaseResponse<DormRooms> getRoomById(DormRoomsDetailRequest request) {
        BaseResponse<DormRooms> response = new BaseResponse<>();
        // FIND ROOM
        DormRooms dormRooms = dormRoomsRepository.findById(request.getRoomId())
                .orElseThrow(() -> new BusinessException("Room Not Found"));

        // RESPONSE
        response.isSuccess();
        response.setData(dormRooms);
        return response;
    }
}
