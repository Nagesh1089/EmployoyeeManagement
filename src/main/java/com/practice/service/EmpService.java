package com.practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.entity.Employee;
import com.practice.repository.EmpRepo;

@Service
public class EmpService 
{

	@Autowired
	private EmpRepo repo;
	public void addEmp(Employee e)
	{
		repo.save(e);
	}
	
	public Employee updateEmployee(int id,Employee newEmp)
	{
		Employee oldEmp=repo.getReferenceById(id);
		//Employee oldEmp=repo.getById(id);
		oldEmp.setAddress(newEmp.getAddress());
		oldEmp.setEmail(newEmp.getEmail());
		oldEmp.setName(newEmp.getName());
		oldEmp.setPhno(newEmp.getPhno()); 
		oldEmp.setSalary(newEmp.getSalary());
		return repo.save(oldEmp);
	}
	
	public List<Employee>getAllEmp()
	{
		return repo.findAll();
	}
	
	public Employee getEmpById(int id)
	{
	Optional<Employee> e=repo.findById(id);
	
	if(e.isPresent())
	{
		return e.get();
	}
	else
	{
		return null;
	}
	
	}
	
	public void deleteEmp(int id)
	{
		repo.deleteById(id);
		
		/*Employee delEmp=repo.getById(id);
		repo.delete(delEmp);*/
		
	}
}


