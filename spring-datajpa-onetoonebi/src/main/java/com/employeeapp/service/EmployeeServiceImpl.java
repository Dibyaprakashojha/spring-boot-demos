package com.employeeapp.service;

import com.employeeapp.model.Employee;
import com.employeeapp.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements IEmployeeService{

    private IEmployeeRepository iEmployeeRepository;
    @Autowired
    public void setiEmployeeRepository(IEmployeeRepository iEmployeeRepository) {
        this.iEmployeeRepository = iEmployeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return iEmployeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(int studentId) {
        iEmployeeRepository.deleteById(studentId);
    }

    @Override
    public Employee getById(int studentId) {
        return iEmployeeRepository.findById(studentId).get();
    }

    @Override
    public List<Employee> getAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public List<Employee> getByDepartment(String department) {
        return iEmployeeRepository.findByDepartment(department);
    }

    @Override
    public List<Employee> getByCity(String city) {
        return iEmployeeRepository.findByBiAddressCity(city);
    }

    @Override
    public List<Employee> getByDeptAndCity(String department, String city) {
        return iEmployeeRepository.findByDeptAndCity(department, city);
    }

    @Override
    public List<Employee> getByState(String state) {
        return iEmployeeRepository.findByState(state);
    }

    @Override
    public List<Employee> getByFlatNumber(String flatNumber) {
        return iEmployeeRepository.findByFlatNumber(flatNumber);
    }
}
