package com.employeemanagement.controller;

import com.employeemanagement.dao.entity.Employee;
import com.employeemanagement.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/")
    public List<Employee> getAllEmployees(){

        return employeeService.getAllEmployees();
    }
    @PostMapping(value = "/add",consumes = {"application/json"})
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }
    @DeleteMapping("/id")
    public void deleteEmployee(Long id){
        employeeService.deleteById(id);
    }



}
