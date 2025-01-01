package com.example.Dormitory.feature.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Dorm_Rooms")
public class DormRooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Room_Id")
    private Integer roomId;

    @Column(name = "RoomType_Id")
    private Integer roomTypeId;

    @Column(name = "Room_Name", length = 150)
    private String roomName;

    @Column(name = "Floor")
    private Integer floor;

    @Column(name = "Capacity")
    private Integer capacity;

    @Column(name = "Bed")
    private Integer bed;

    @Column(name = "Note", length = 200)
    private String note;

    @Column(name = "CreateUID")
    private Integer createUID;

    @Column(name = "CreateDate")
    private LocalDateTime createDate;

    @PostPersist
    private void beforeSave(){
        createDate = LocalDateTime.now();
    }
}
