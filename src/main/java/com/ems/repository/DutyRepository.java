package com.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.entity.Duty;

@Repository
public interface DutyRepository extends JpaRepository<Duty,Long> {

}
