package com.example.employee_service.service.impl;

import com.example.employee_service.dto.ApiResponseDto;
import com.example.employee_service.dto.DepartmentDto;
import com.example.employee_service.dto.EmployeeDto;
import com.example.employee_service.entity.Employee;
import com.example.employee_service.mapper.EmployeeMapper;
import com.example.employee_service.repository.EmployeeRepository;
import com.example.employee_service.service.ApiClient;
import com.example.employee_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private ApiClient apiClient;
//    private RestTemplate restTemplate;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public ApiResponseDto getEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(
//                "http://localhost:8080/api/departments/" + employeeDto.getDepartmentCode(),
//                DepartmentDto.class
//        );
//        ResponseEntity<DepartmentDto> responseEntity = apiClient.getDepartment(employeeDto.getDepartmentCode());
//        DepartmentDto departmentDto = responseEntity.getBody();
        DepartmentDto departmentDto = apiClient.getDepartment(employeeDto.getDepartmentCode());

        ApiResponseDto apiResponseDto = new ApiResponseDto(employeeDto, departmentDto);

        return apiResponseDto;
    }
}
