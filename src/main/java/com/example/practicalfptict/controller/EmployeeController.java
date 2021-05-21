package com.example.practicalfptict.controller;
import com.example.practicalfptict.jpa.Employee;
import com.example.practicalfptict.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(path = "/")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping(path = "")
    public String getAllEmployee(Model model)
    {
        List<Employee> list = employeeService.listEmployee();
        model.addAttribute("list",list);
        return "employee/list";
    }

    @RequestMapping("/addEmployee")
    public String insertComment(Model model)
    {
        Employee employee = new Employee();
        model.addAttribute("newEmployee",employee);
        return "employee/addEmployee";
    }
    @RequestMapping(path = "/saveEmployee",method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("saveEmployee")Employee employee)
    {
        boolean bl = employeeService.saveEmployee(employee);
        if (bl)
        {
            return "employee/list";
        }
        return "employee/list";
    }
    @RequestMapping(value = "/editEmployee")
    public String editComment(@RequestParam("id")Integer id, Model model)
    {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("editEmployee",employee);
        return "employee/Edit";
    }
    @RequestMapping(path = "/updateEmployee", method = RequestMethod.POST)
    public String updateComment(@ModelAttribute("updateEmployee") Employee employee) {
        boolean bl = employeeService.updateEmployee(employee);
        if (bl) {
            return "employee/list";
        }
        return "employee/list";

    }
}
