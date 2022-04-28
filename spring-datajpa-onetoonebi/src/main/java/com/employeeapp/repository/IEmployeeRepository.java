package com.employeeapp.repository;

import com.employeeapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findByDepartment(String department);
    List<Employee> findByBiAddressCity(String city);

//    @Query("from Employee e inner join e.biAddress b where b.city=?1")
//    List<Employee> findByCity(String city);
    @Query("from Employee e inner join e.biAddress b where e.department=?1 and b.city=?2")
    List<Employee> findByDeptAndCity(String department,String city);
    @Query("from Employee e inner join e.biAddress b where b.state=?1")
    List<Employee> findByState(String state);
    @Query("from Employee e inner join e.biAddress b where b.flatNumber=?1")
    List<Employee> findByFlatNumber(String flatNumber);

}
