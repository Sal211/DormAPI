package com.example.Dormitory.feature.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
@Table(name = "Dorm_BookingRoomTrans")
public class BookingRoomTrans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Tran_Id")
    private Integer tranId;

    @Column(name = "roomId")
    private Integer roomId;

    @Column(name = "StudentId")
    private Long studentId;

    @Column(name = "StartDate")
    private LocalDate startDate;

    @Column(name = "StartTime")
    private LocalTime startTime;

    @Column(name = "EndDate")
    private LocalDate endDate;

    @Column(name = "EndTime")
    private LocalTime endTime;

    @Column(name = "TuitionDue", precision = 7, scale = 2)
    private BigDecimal tuitionDue;

    @Column(name = "TuitionPaid", precision = 7, scale = 2)
    private BigDecimal tuitionPaid;

    @Column(name = "TuitionFee", precision = 7, scale = 2)
    private BigDecimal tuitionFee;

    @Column(name = "TenantType")
    private Integer tenantType;

    @Column(name = "discount")
    private double discount;

    @Column(name = "IsPaid")
    private Boolean isPaid;

    @Column(name = "Cus_Type")
    private Boolean cusType;

    @Column(name = "CreateUID")
    private Integer createUID;

    @Column(name = "CreateDate")
    private LocalDateTime createDate;

    @PostPersist
    private void beforeSave(){
        createDate = LocalDateTime.now();
    }
}
