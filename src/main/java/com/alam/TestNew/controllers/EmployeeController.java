package com.alam.TestNew.controllers;

import com.alam.TestNew.dto.EmployeeDto;
import com.alam.TestNew.entities.EmployeeEntity;
import com.alam.TestNew.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

//    public EmployeeController(EmployeeService service) {
//        this.service = service;
//    }
//
//    @GetMapping
//    public List<EmployeeEntity> getAllEmployees() {
//        return service.getAllEmployees();
//    }
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public EmployeeDto createNewEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.createNewEmployee(employeeDto);
    }

    @PutMapping("/{id}")
    public EmployeeDto updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        return employeeService.updateEmployee(id, employeeDto);
    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
//        service.deleteEmployee(id);
//        return ResponseEntity.noContent().build();
//    }
}


