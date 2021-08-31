package com.example.manpower.service;

import com.example.manpower.entity.Department;
import com.example.manpower.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    public List<Department> getAllDepartment(){
        return departmentRepository.findAll();
    }
    public void saveDepartment(Department department) {
        departmentRepository.save(department);
    }
    public Department getDepartmentById(Long id){
        Optional<Department> optional=departmentRepository.findById(id);
        Department department= optional.get();
        return department;
    }
    public void deleteDepartmentById(long id){
        departmentRepository.deleteById(id);

    }
}
