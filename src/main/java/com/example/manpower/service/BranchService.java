package com.example.manpower.service;

import com.example.manpower.entity.Branch;
import com.example.manpower.entity.Employee;
import com.example.manpower.repository.BranchRepository;
import com.example.manpower.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchService {
    @Autowired
    private BranchRepository branchRepository;
    public List<Branch> getAllBranch(){
        return branchRepository.findAll();
    }
    public void saveBranch(Branch branch) {
        branchRepository.save(branch);
    }
    public Branch getBranchtById(Long id){
        Optional<Branch> optional=branchRepository.findById(id);
        Branch branch= optional.get();
        return branch;
    }
    public void deleteBranchById(long id){
        branchRepository.deleteById( id);
    }

}
