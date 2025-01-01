package com.example.Dormitory.feature.service.impl;

import com.example.Dormitory.exceptions.BusinessException;
import com.example.Dormitory.feature.dto.request.bookingRoom.BookingRoomDetailRequest;
import com.example.Dormitory.feature.dto.request.bookingRoom.BookingRoomRequest;
import com.example.Dormitory.feature.dto.request.bookingRoom.BookingRoomUpdateRequest;
import com.example.Dormitory.feature.entity.BookingRoomTrans;
import com.example.Dormitory.feature.entity.DormRoomPrice;
import com.example.Dormitory.feature.repository.BookingRoomTransRepository;
import com.example.Dormitory.feature.repository.DormRoomPriceRepository;
import com.example.Dormitory.feature.repository.DormRoomsRepository;
import com.example.Dormitory.feature.service.BookingRoomService;
import com.example.Dormitory.feature.util.BaseResponse;
import com.example.Dormitory.feature.util.mapper.BookingRoomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BookingRoomTransServiceImpl implements BookingRoomService {

    private final DormRoomsRepository dormRoomsRepository;
    private final BookingRoomTransRepository bookingRoomTransRepository;
    private final BookingRoomMapper bookingRoomMapper;
    private final DormRoomPriceRepository dormRoomPriceRepository;

    @Override
    public BaseResponse<Void> createRoom(BookingRoomRequest request) {
        BaseResponse<Void> response = new BaseResponse<>();

        int totalTenant = bookingRoomTransRepository.totalTenant(request.getRoomId());
        int capacity = dormRoomsRepository.findById(request.getRoomId())
                .orElseThrow(() -> new BusinessException("Room Not Found"))
                .getCapacity();

        if(totalTenant >= capacity) throw new BusinessException("Room is full");
        // SAVE ROOM
        BookingRoomTrans bookingRoomTrans = bookingRoomMapper.toBookingRoom(request);
        bookingRoomTransRepository.save(bookingRoomTrans);

        // RESPONSE
        response.isSuccess();
        return response;
    }

    @Override
    public BaseResponse<Void> updateRoom(BookingRoomUpdateRequest request) {
        return null;
    }

    @Override
    public BaseResponse<Void> deleteRoom(BookingRoomDetailRequest request) {
        return null;
    }

    @Override
    public BaseResponse<List<BookingRoomTrans>> getAllRoom(BookingRoomDetailRequest request) {
        return null;
    }

    @Override
    public BaseResponse<BookingRoomTrans> getRoomById(BookingRoomDetailRequest request) {
        return null;
    }

    private BigDecimal calculateTuitionFee(LocalDate startDate, LocalDate endDate, int roomId){
        DormRoomPrice dormRoomPrice = dormRoomPriceRepository.findByRoomId(roomId);

        return BigDecimal.ZERO;
    }

    private boolean isLastDayOfMonth(LocalDate date){
        YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonth());
        int lastDay =  yearMonth.lengthOfMonth();
        return date.getDayOfMonth() == lastDay;
    }
}
