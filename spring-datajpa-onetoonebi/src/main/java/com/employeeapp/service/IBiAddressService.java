package com.employeeapp.service;

import com.employeeapp.model.BiAddress;

import java.util.List;

public interface IBiAddressService {

    List<BiAddress> getByName(String employeeName);
    List<BiAddress> getByDepartment(String department);
    List<BiAddress> getByNameAndCity(String name, String city);
    BiAddress getByEmpId(int employeeId);
    List<BiAddress> getByNameStreet(String name,String streetname);
    List<BiAddress> getByCity(String city);




}
