package com.callmeocean.employeecontactmanagerservice.repositories;

import com.callmeocean.employeecontactmanagerservice.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
