package com.example.Dormitory.feature.repository;

import com.example.Dormitory.feature.entity.DormRoomType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DormRoomTypeRepository extends JpaRepository<DormRoomType, Integer> {
    boolean existsByRoomTypeName(String roomTypeName);
}
