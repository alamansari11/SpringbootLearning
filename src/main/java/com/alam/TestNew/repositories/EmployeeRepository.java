package com.alam.TestNew.repositories;


import com.alam.TestNew.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    //JpaRepository Entity and primary  key ka type
}