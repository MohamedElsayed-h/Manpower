package com.example.manpower.controller;

import com.example.manpower.entity.Branch;
import com.example.manpower.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BranchController {
    @Autowired
    private BranchService branchService;
    @GetMapping("/branch")
    public String showAllBranch(Model model){
        model.addAttribute("ListBranches",branchService.getAllBranch());
        return "branch";
    }
    @GetMapping("/addNewBranch")
    public String addNewBranch(Model model){
        Branch branch=new Branch();
        model.addAttribute("branch",branch);
        return "newBranch";
    }
    @PostMapping("/saveBranch")
    public String saveBranch(@ModelAttribute("branch") Branch branch){
        branchService.saveBranch(branch);
        return "redirect:/branch";
    }
    @GetMapping("/UpdateBranchForm/{id}")
    public String UpdateBranchForm(@PathVariable(value = "id")long id, Model model){
        Branch branch=branchService.getBranchtById(id);
        model.addAttribute("branch",branch);
        return "updateBranch";
    }
    @GetMapping("/DeleteBranch/{id}")
    public String DeleteBranch(@PathVariable(value = "id")long id){
        branchService.deleteBranchById(id);
        return "redirect:/branch";
    }


}
