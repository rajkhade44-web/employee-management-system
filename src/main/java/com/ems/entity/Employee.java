package com.ems.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "employees")
public class Employee extends BaseEntity {
    @Column(name = "employee_code",unique = true, length = 20)
    private String employeeCode;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(length = 500)
    private String address;

    @Column(name = "joining_date",nullable = false)
    private LocalDate joiningDate;

    @Column(nullable = false, precision = 10,scale = 2)
    private BigDecimal salary;

    @Column(nullable = false, length = 100)
    private String designation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department dapartment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @OneToMany(mappedBy = "manager",fetch = FetchType.LAZY)
    private List<Employee> subordinates;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",nullable = false,unique = true)
    private User user;
}
