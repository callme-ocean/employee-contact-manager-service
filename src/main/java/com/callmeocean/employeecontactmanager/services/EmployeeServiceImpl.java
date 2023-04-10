package com.callmeocean.employeecontactmanager.services;

import com.callmeocean.employeecontactmanager.entities.EmployeeEntity;
import com.callmeocean.employeecontactmanager.exceptions.UserNotFoundException;
import com.callmeocean.employeecontactmanager.models.Employee;
import com.callmeocean.employeecontactmanager.repositories.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();

        BeanUtils.copyProperties(employee, employeeEntity);
        employeeEntity.setEmployeeCode(UUID.randomUUID().toString());
        EmployeeEntity employeeAdded = employeeRepository.save(employeeEntity);
        BeanUtils.copyProperties(employeeAdded, employee);

        return employee;
    }

    @Override
    public List<Employee> findAllEmployees() {

        List<EmployeeEntity> allEmployeesList = employeeRepository.findAll();
        List<Employee> resultList = new ArrayList<>();

        for (EmployeeEntity employeeEntity : allEmployeesList) {
            Employee employee = new Employee();

            BeanUtils.copyProperties(employeeEntity, employee);
            resultList.add(employee);
        }

        return resultList;
    }

    @Override
    public Employee updateEmployee(Employee employee) {

        EmployeeEntity employeeEntity = employeeRepository.findById(employee.getId())
                .orElseThrow(() -> new UserNotFoundException("User with ID:" + employee.getId() + "not found"));

        employeeEntity.setId(employee.getId());
        employeeEntity.setName(employee.getName());
        employeeEntity.setEmail(employee.getEmail());
        employeeEntity.setEmployeeCode(employee.getEmployeeCode());
        employeeEntity.setImageUrl(employee.getImageUrl());
        employeeEntity.setJobTitle(employee.getJobTitle());
        employeeEntity.setPhoneNumber(employee.getPhoneNumber());

        EmployeeEntity updatedEmployeeEnitity = employeeRepository.save(employeeEntity);

        BeanUtils.copyProperties(updatedEmployeeEnitity, employee);

        return employee;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findEmployeeById(Long id) {
        Employee employee = new Employee();

        EmployeeEntity employeeEntity = employeeRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with ID:" + id + "not found"));
        BeanUtils.copyProperties(employeeEntity, employee);

        return employee;
    }


}
