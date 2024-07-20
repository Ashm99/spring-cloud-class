package com.example.department_service.mapper;

import com.example.department_service.dto.DepartmentDto;
import com.example.department_service.entity.Department;

public class DepartmentMapper {
    public static Department mapToDepartment(DepartmentDto departmentDto) {
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentCode(),
                departmentDto.getDepartmentDescription()
        );
        return department;
    }

    public static DepartmentDto mapToDepartmentDto(Department department) {
        DepartmentDto departmentDto = new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentCode(),
                department.getDepartmentDescription()
        );
        return departmentDto;
    }

}
