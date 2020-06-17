package com.offcn.controller;


import com.offcn.springboot.dao.DepartmentDao;
import com.offcn.springboot.dao.EmployeeDao;
import com.offcn.springboot.entities.Department;
import com.offcn.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.websocket.server.PathParam;
import java.util.Collection;

@Controller
public class EmployeeController {


    @Autowired
    DepartmentDao departmentDao;

    @Autowired
    EmployeeDao employeeDao;

    @GetMapping("/emps")
    public String list(Model model){

        Collection<Employee> employees = employeeDao.getAll();

        model.addAttribute("emps",employees);

        return "emp/list";
    }

    //跳转添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){


        Collection<Department> departments = departmentDao.getDepartments();

        model.addAttribute("depts",departments);


        return  "emp/add";
    }


    //y员工添加功能

    @PostMapping("/emp")
    public  String addEmp(Employee employee){
        //重定向的这个/的意思是当前项目

        System.out.printf("保存的员工信息"+employee);

        employeeDao.save(employee);
        return "redirect:/emps";
    }


    @GetMapping("/emp/{id}")
    public String toEditPage(@PathParam("id") Integer id,Model model){

        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);

        //部门的显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);

        return "emp/add";
    }

}
