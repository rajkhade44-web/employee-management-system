package com.ems.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
@Table(name = "departments",
            uniqueConstraints = {@UniqueConstraint(columnNames = "name")}
)
public class Department extends BaseEntity {
    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 500)
    private String description;

    // ONE to MANY Relation Dept--->Employee
    @OneToMany(mappedBy = "department")
    private List<Employee> employee;
}
