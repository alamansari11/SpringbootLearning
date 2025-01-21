package com.alam.TestNew.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
// we are giving the table name so that it can refer it
@Table(name = "employees")
public class EmployeeEntity {

    // this is to know that this is the primary key
    @Id
    //automatically generates the id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate dateOfJoining;
    private boolean active;
}
