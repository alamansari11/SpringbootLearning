package com.alam.TestNew.service;

import com.alam.TestNew.dto.EmployeeDto;
import com.alam.TestNew.entities.EmployeeEntity;
import com.alam.TestNew.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;

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

    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        EmployeeEntity existingEmployee = employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Employee not found3"));
        modelMapper.map(employeeDto,existingEmployee);
        EmployeeEntity updatedEmployee = employeeRepository.save(existingEmployee);
        return modelMapper.map(updatedEmployee,EmployeeDto.class);
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