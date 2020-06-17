package com.offcn.springboot.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.offcn.springboot.entities.Department;
import org.springframework.stereotype.Repository;


@Repository
public class DepartmentDao {

	private static Map<Integer, Department> departments = null;
	
	static{
		departments = new HashMap<Integer, Department>();
		
		departments.put(101, new Department(101, "研发部"));
		departments.put(102, new Department(102, "金融部"));
		departments.put(103, new Department(103, "美工部"));
		departments.put(104, new Department(104, "后勤部"));
		departments.put(105, new Department(105, "外销部"));
	}
	
	public Collection<Department> getDepartments(){
		return departments.values();
	}
	
	public Department getDepartment(Integer id){
		return departments.get(id);
	}
	
}
