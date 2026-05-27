package com.ems.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import com.ems.enums.AttendanceStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="attendance")
public class Attendance extends BaseEntity {

    @Column(name = "attendance_date",nullable = false,unique = true)
    private LocalDate attendanceDate;
    
    @Column(name = "check_in_time")
    private LocalTime checkInTime;

    @Column(name = "check_out_time")
    private LocalTime checkOutTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AttendanceStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id",unique = true)
    private Employee employee;
}
