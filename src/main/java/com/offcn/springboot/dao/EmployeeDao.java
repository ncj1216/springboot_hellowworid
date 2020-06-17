package com.offcn.springboot.dao;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.offcn.springboot.entities.Department;
import com.offcn.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class EmployeeDao {

	private static Map<Integer, Employee> employees = null;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	static{
		employees = new HashMap<Integer, Employee>();

		employees.put(1001, new Employee(1001, "卢本伟", "aa@163.com", 1, new Department(101, "研发部")));
		employees.put(1002, new Employee(1002, "李元昊", "bb@163.com", 1, new Department(102, "金融部")));
		employees.put(1003, new Employee(1003, "刘梦麟", "cc@163.com", 0, new Department(103, "美工部")));
		employees.put(1004, new Employee(1004, "张旭", "dd@163.com", 0, new Department(104, "后勤部")));
		employees.put(1005, new Employee(1005, "王德法", "ee@163.com", 1, new Department(105, "外销部")));
	}
	
	private static Integer initId = 1006;
	
	public void save(Employee employee){
		if(employee.getId() == null){
			employee.setId(initId++);
		}
		
		employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
		employees.put(employee.getId(), employee);
	}
	
	public Collection<Employee> getAll(){
		return employees.values();
	}
	
	public Employee get(Integer id){
		return employees.get(id);
	}
	
	public void delete(Integer id){
		employees.remove(id);
	}
}
