package com.alam.TestNew.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long id;
    private String name;
    private LocalDate dateOfJoining;
    // json property will tell jackson that we want this vairable name as isActive only not active
    @JsonProperty("isActive")
    private boolean isActive;
}
