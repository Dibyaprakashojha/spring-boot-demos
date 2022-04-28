package com.employeeapp.service;

import com.employeeapp.model.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int studentId);
    Employee getById(int studentId);
    List<Employee> getAll();

    //derived queries
    List<Employee> getByDepartment(String department);
    List<Employee> getByCity(String city);



    //custom queries
    List<Employee> getByDeptAndCity(String department,String city);
    List<Employee> getByState(String state);
    List<Employee> getByFlatNumber(String flatNumber);

}
