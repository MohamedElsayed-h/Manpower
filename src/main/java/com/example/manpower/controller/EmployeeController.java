package com.example.manpower.controller;

import com.example.manpower.entity.Branch;
import com.example.manpower.entity.Department;
import com.example.manpower.entity.Employee;
import com.example.manpower.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee.html.html")
    public String showEmployeeForm(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return"redirect:/homePage";
    }

    @GetMapping("/department.html")
    public String showDepartmentForm(Model model){
        Department department=new Department();
        model.addAttribute("department",department);
        return"redirect:/dept";
    }

    @GetMapping("/branch.html")
    public String showBranchForm(Model model){
        Branch branch=new Branch();
        model.addAttribute("branch",branch);
        return"redirect:/branch";
    }
    @GetMapping("/homePage")
    public String showAllEmployee(Model model){
        model.addAttribute("ListEmployees",employeeService.getAllEmployees());
        return "index";
    }

    @GetMapping("/addNewEmployee")
    public String addNewEmployee(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return"newEmployee";
    }
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/homePage";
    }
    @GetMapping("/UpdateForm/{id}")
    public String UpdateForm(@PathVariable(value = "id")long id, Model model){
        Employee employee=employeeService.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return "updateEmployee";
    }


    @GetMapping("/DeleteEmployee/{id}")
    public String DeleteEmployee(@PathVariable(value = "id") long id){
        employeeService.deleteEmployeeById(id);
        return "redirect:/homePage";
    }

}
