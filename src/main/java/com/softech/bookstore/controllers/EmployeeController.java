package com.softech.bookstore.controllers;

import com.softech.bookstore.models.Employee;
import com.softech.bookstore.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("")
    public String list(ModelMap map){
        Iterable<Employee> employees = employeeService.findAll();
        map.addAttribute("employees", employees);
        return "employees/list";
    }

    @RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
    public String newBook(ModelMap map){
        Employee employee = new Employee();
        map.addAttribute("employee", employee);

        return "employees/saveEmployee";
    }

    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public String saveOrUpdate(@ModelAttribute Employee employee){
        employeeService.save(employee);
        return "redirect:/employee";
    }
}
