package com.example.Dormitory.feature.repository;

import com.example.Dormitory.feature.entity.DormRooms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DormRoomsRepository extends JpaRepository<DormRooms, Integer> {
    boolean existsByRoomName(String roomName);
    boolean existsByRoomTypeId(Integer roomTypeId);
}
