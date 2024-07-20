package com.example.department_service.service;

import com.example.department_service.dto.DepartmentDto;
import com.example.department_service.entity.Department;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartment(String code);
}
