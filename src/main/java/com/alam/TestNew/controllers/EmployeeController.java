package com.alam.TestNew.controllers;

import com.alam.TestNew.dto.EmployeeDto;
import com.alam.TestNew.entities.EmployeeEntity;
import com.alam.TestNew.service.EmployeeService;
import jakarta.websocket.server.PathParam;
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

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @GetMapping
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public EmployeeDto createNewEmployee(@PathParam("test") String test, @RequestBody EmployeeDto employeeDto) {
        System.out.println("test query params: " +  test);
        return employeeService.createNewEmployee(employeeDto);
    }

    @PutMapping("/{id}")
    public EmployeeDto updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        return employeeService.updateEmployee(id, employeeDto);
    }

    @PutMapping("toggle/{id}")
    public EmployeeDto toggleEmployee(@PathVariable Long id) {
        return employeeService.toggleEmployee(id);
    }
//
    @DeleteMapping("/{id}")
    public boolean deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployeeById(id);
    }

}


