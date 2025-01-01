package com.example.Dormitory.feature.repository;


import com.example.Dormitory.feature.entity.DormRoomPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DormRoomPriceRepository extends JpaRepository<DormRoomPrice, Integer> {
    boolean existsByRoomId(int roomId);
    DormRoomPrice findByRoomId(int roomId);
}
