package com.example.manpower.controller;

import com.example.manpower.entity.Department;
import com.example.manpower.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/dept")
    public String showAllDepartment(Model model){
        model.addAttribute("ListDepartments",departmentService.getAllDepartment());
        return "department";
    }
    @GetMapping("/addNewDepartment")
    public String addNewDepartment(Model model){
        Department department=new Department();
        model.addAttribute("department",department);
        return"newDepartment";
    }
    @PostMapping("/saveDepartment")
    public String saveDepartment(@ModelAttribute("department") Department department ){
        departmentService.saveDepartment(department);
        return "redirect:/dept";
    }
    @GetMapping("/UpdateDeptForm/{id}")
    public String UpdateDeptForm(@PathVariable(value = "id")long id, Model model){
        Department department=departmentService.getDepartmentById(id);
        model.addAttribute("department",department);
        return "updateDepartment";
    }
    @GetMapping("/DeleteDepartment/{id}")
    public String DeleteDepartment(@PathVariable(value = "id") long id){
        departmentService.deleteDepartmentById(id);
        return "redirect:/dept";
    }
}
