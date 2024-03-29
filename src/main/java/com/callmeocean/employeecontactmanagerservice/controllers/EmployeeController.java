package com.callmeocean.employeecontactmanagerservice.controllers;

import com.callmeocean.employeecontactmanagerservice.models.Employee;
import com.callmeocean.employeecontactmanagerservice.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/v1/all")
    public ResponseEntity<List<Employee>> findAllEmployees() {
        List<Employee> allEmployeesList = employeeService.findAllEmployees();

        return new ResponseEntity<>(allEmployeesList, HttpStatus.OK);
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable("id") Long id) {
        Employee employeeFound = employeeService.findEmployeeById(id);

        return new ResponseEntity<>(employeeFound, HttpStatus.OK);
    }

    @PostMapping("/v1/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee addedEmployee = employeeService.addEmployee(employee);

        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PutMapping("/v1/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee addedEmployee = employeeService.updateEmployee(employee);

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/v1/delete/{id}")
    public ResponseEntity<?> deleteMapping(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
