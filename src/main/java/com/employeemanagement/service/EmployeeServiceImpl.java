package com.employeemanagement.service;

import com.employeemanagement.dao.EmployeeRepository;
import com.employeemanagement.dao.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
        //employeeRepository.flush();
    }
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    public void deleteById(Long id){
        employeeRepository.deleteById(id);
    }
//    public void updateById(Long Id){
//        employeeRepository.
//    }


}
