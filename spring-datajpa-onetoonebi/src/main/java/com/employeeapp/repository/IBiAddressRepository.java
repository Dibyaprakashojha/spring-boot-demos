package com.employeeapp.repository;

import com.employeeapp.model.BiAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBiAddressRepository extends JpaRepository<BiAddress,Integer> {
    @Query("from BiAddress b inner join b.employee e where e.name like ?1")
    List<BiAddress> findByName(String employeeName);
    @Query("from BiAddress b inner join b.employee e where e.department=?1")
    List<BiAddress> findByDepartment(String department);
    @Query("from BiAddress b inner join b.employee e where e.name=?1 and b.city=?2")
    List<BiAddress> findByNameAndCity(String name, String city);
    @Query("from BiAddress b inner join b.employee e where e.employeeId=?1")
    BiAddress findByEmpId(int employeeId);
    @Query("from BiAddress b inner join b.employee e where e.name=?1 and b.streetname=?2")
    List<BiAddress> findByNameStreet(String name,String streetname);
    @Query("from BiAddress b inner join b.employee e where b.city=?1")
    List<BiAddress> findByCity(String city);
}
