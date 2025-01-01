package com.example.Dormitory.feature.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Dorm_RoomPriceSetting")
public class DormRoomPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Price_Id")
    private Integer priceId;

    @Column(name = "Room_Id")
    private Integer roomId;

    @Column(name = "FullPrice_Month", precision = 7, scale = 2)
    private BigDecimal fullPriceMonth;

    @Column(name = "FullPrice_Day", precision = 7, scale = 2)
    private BigDecimal fullPriceDay;

    @Column(name = "PricePer_Month", precision = 7, scale = 2)
    private BigDecimal pricePerMonth;

    @Column(name = "PricePer_Day", precision = 7, scale = 2)
    private BigDecimal pricePerDay;

    @Column(name = "CreateUID")
    private Integer createUID;

    @Column(name = "CreateDate")
    private LocalDateTime createDate;

    @PostPersist
    private void beforeSave() {
        createDate = LocalDateTime.now();
    }
}
