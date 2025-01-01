package com.example.Dormitory.feature.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Dorm_RoomType")
public class DormRoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RoomType_Id")
    private Integer roomTypeId;

    @Column(name = "Type_Name", length = 100)
    private String roomTypeName;

    @Column(name = "Description", length = 200)
    private String description;

    @Column(name = "CreateUID")
    private Integer createUID;

    @Column(name = "CreateDate")
    private LocalDateTime createDate;

    @PostPersist
    private void beforeSave(){
        createDate = LocalDateTime.now();
    }

}
