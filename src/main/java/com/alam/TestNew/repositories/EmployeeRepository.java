package com.alam.TestNew.repositories;


import com.alam.TestNew.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    //JpaRepository Entity and primary  key ka type
//    @Transactional
//    @Modifying
//    @Query("UPDATE EmployeeEntity e SET e.active = :active WHERE e.id = :id")
//    int updateEmployeeSalary(@Param("id") Long id, @Param("name") String name);
    @Modifying
    @Transactional
    @Query("UPDATE EmployeeEntity e SET e.active = CASE WHEN e.active = true THEN false ELSE true END WHERE e.id = :id")
    int toggleEmployeeActiveStatus(@Param("id") Long id);



}