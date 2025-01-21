package com.alam.TestNew.service;

import com.alam.TestNew.dto.EmployeeDto;
import com.alam.TestNew.entities.EmployeeEntity;
import com.alam.TestNew.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    final EmployeeRepository employeeRepository;
    final ModelMapper modelMapper;

    // this most probably likely a constructure
    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper){
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDto getEmployeeById(Long id){
        EmployeeEntity employeeEntity  = employeeRepository.getById(id);
//        return new EmployeeDto(employeeEntity.getId(),employeeEntity.getName(),employeeEntity.getDateOfJoining(),employeeEntity.getisActive());
        return modelMapper.map(employeeEntity,EmployeeDto.class);
    }

    public EmployeeDto createNewEmployee(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDto,EmployeeEntity.class);
        return modelMapper.map(employeeRepository.save(employeeEntity),EmployeeDto.class);
    }

    //        Default Behavior for Boolean Fields
//        When a boolean field is named with an is prefix, JavaBean conventions dictate:
//
//        The getter method should be named isActive().
//                The setter method should be named setActive(boolean active).
//        existingEmployee.setActive(employeeDto.isActive());
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        EmployeeEntity existingEmployee = employeeRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));;
        modelMapper.map(employeeDto,EmployeeEntity.class);
        existingEmployee.setName(employeeDto.getName());
        existingEmployee.setDateOfJoining(employeeDto.getDateOfJoining());
        existingEmployee.setActive(employeeDto.isActive());
        return modelMapper.map(employeeRepository.save(existingEmployee),EmployeeDto.class);
    }
//    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
//        // Find the existing employee or throw an exception if not found
//        EmployeeEntity existingEmployee = employeeRepository.findById(id)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
//
//        // Map non-null fields from DTO to the existing entity
//        modelMapper.map(employeeDto, existingEmployee);
//
//        // Save the updated entity and map it back to DTO
//        EmployeeEntity updatedEmployee = employeeRepository.save(existingEmployee);
//        return modelMapper.map(updatedEmployee, EmployeeDto.class);
//    }

    // instead of going through all the employees in the list and mnaually converting it to dto we are using stream
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository
                .findAll()
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    public boolean deleteEmployeeById(Long id) {
        boolean isPresent = employeeRepository.existsById(id);
        if(!isPresent) return false;
        employeeRepository.deleteById(id);
        return true;
    }

    public EmployeeDto toggleEmployee(Long id) {
        EmployeeEntity existingEmployee = employeeRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));;
        employeeRepository.toggleEmployeeActiveStatus(id);
        return modelMapper.map(employeeRepository.findById(id),EmployeeDto.class);
//        return true;
    }


//    public EmployeeService(EmployeeRepository repository) {
//        this.repository = repository;
//    }
//
//    public List<EmployeeEntity> getAllEmployees() {
//        return repository.findAll();
//    }
//
//    public EmployeeEntity getEmployeeById(Long id) {
//        return repository.findById(id).orElseThrow(() -> new RuntimeException("EmployeeEntity not found"));
//    }
//
//    public EmployeeEntity createEmployee(EmployeeEntity employee) {
//        return repository.save(employee);
//    }
//
//    public EmployeeEntity updateEmployee(Long id, EmployeeEntity updatedEmployee) {
//        EmployeeEntity existingEmployee = getEmployeeById(id);
//        existingEmployee.setName(updatedEmployee.getName());
//        existingEmployee.setDepartment(updatedEmployee.getDepartment());
//        existingEmployee.setSalary(updatedEmployee.getSalary());
//        return repository.save(existingEmployee);
//    }
//
//    public void deleteEmployee(Long id) {
//        repository.deleteById(id);
//    }
}