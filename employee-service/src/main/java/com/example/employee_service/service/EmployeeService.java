package com.example.employee_service.service;

import com.example.employee_service.dto.ApiResponseDto;
import com.example.employee_service.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    ApiResponseDto getEmployee(Long employeeId);

}
