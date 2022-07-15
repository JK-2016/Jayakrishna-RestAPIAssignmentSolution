package com.employeemanagement.controller;

import com.employeemanagement.dao.entity.Employee;
import com.employeemanagement.dao.entity.Role;
import com.employeemanagement.service.EmployeeServiceImpl;
import com.employeemanagement.service.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;
    private RoleServiceImpl roleService;

    @GetMapping("/")
    public List<Employee> getAllEmployees(){

        return employeeService.getAllEmployees();
    }
    @PostMapping(value = "/add",consumes = {"application/json"})
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteById(id);
    }
    @GetMapping("/{id}")
    public Optional<Employee> getEmployee(@PathVariable Long id){
        return employeeService.getEmployeeByID(id);
    }



    @PutMapping(value="/update")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @GetMapping("/getCustomSortedByName")
    public List<Employee> getEmployeesCustomSortedByName(Sort.Direction direction) {
        return employeeService.getEmployeesCustomSortedByName(direction);
    }

    @GetMapping("/search")
    public List<Employee> searchEmployeeByName(String name){
        return employeeService.searchEmployeeByName(name);
    }



}
