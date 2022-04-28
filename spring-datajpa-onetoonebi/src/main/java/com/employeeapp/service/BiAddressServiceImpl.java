package com.employeeapp.service;

import com.employeeapp.model.BiAddress;
import com.employeeapp.repository.IBiAddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BiAddressServiceImpl implements IBiAddressService {
    IBiAddressRepository iBiAddressRepository;

    public BiAddressServiceImpl(IBiAddressRepository iBiAddressRepository) {
        this.iBiAddressRepository = iBiAddressRepository;
    }


    @Override
    public List<BiAddress> getByName(String employeeName) {
        return iBiAddressRepository.findByName("%"+employeeName);
    }

    @Override
    public List<BiAddress> getByDepartment(String department) {
        return iBiAddressRepository.findByDepartment(department);

    }

    @Override
    public List<BiAddress> getByNameAndCity(String name, String city) {
        return iBiAddressRepository.findByNameAndCity(name, city);

    }

    @Override
    public BiAddress getByEmpId(int employeeId) {
        return iBiAddressRepository.findByEmpId(employeeId);

    }

    @Override
    public List<BiAddress> getByNameStreet(String name, String streetname) {
        return iBiAddressRepository.findByNameStreet(name,streetname);

    }

    @Override
    public List<BiAddress> getByCity(String city) {
        return iBiAddressRepository.findByCity(city);

    }
}
