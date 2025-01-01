package com.example.Dormitory.feature.repository;

import com.example.Dormitory.feature.entity.BookingRoomTrans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingRoomTransRepository extends JpaRepository<BookingRoomTrans, Integer> {

    @Query(
            value = """ 
                    SELECT COUNT(*) FROM dorm_booking_room_trans
                    WHERE end_date >= CONVERT(date,GETDATE()) 
                    AND DATEADD(HOUR, 1, CAST(end_date AS DATETIME) + CAST(end_time AS DATETIME)) >= GETDATE()
                    AND room_id = ?1
            """,nativeQuery = true
    )
    int totalTenant(int roomId);
}
