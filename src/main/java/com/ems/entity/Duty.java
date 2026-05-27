package com.ems.entity;

import java.time.LocalDate;

import com.ems.enums.DutyPriority;
import com.ems.enums.DutyStatus;

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

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "duties")
public class Duty extends BaseEntity{
    @Column(nullable = false, length = 150)
    private String title;

    @Column(nullable = false, length=500)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DutyPriority priority;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DutyStatus status;

    @Column(name = "assigned_date", nullable = false)
    private LocalDate assignedDate;

    @Column(nullable = false)
    private LocalDate deadline;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_by")
    private User assignedBY;
}
