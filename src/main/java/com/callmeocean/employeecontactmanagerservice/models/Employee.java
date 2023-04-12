package com.callmeocean.employeecontactmanagerservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Long id;
    private String name;
    private String email;
    private String jobTitle;
    private String phoneNumber;
    private String imageUrl;
    private String employeeCode;
}
