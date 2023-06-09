package com.practice.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



import com.practice.entity.Employee;
import com.practice.service.EmpService;

import jakarta.servlet.http.HttpSession;

@RestController("/")
public class EmpController 
{
	@Autowired
	private EmpService service;
	@GetMapping("/")
	public String home(Model m)
	{
		List<Employee>emp=service.getAllEmp();
		m.addAttribute("emp",emp);
		return "index";
	}
	@GetMapping("/addemp")
	public String addEmpForm()
	{
		return "add_emp";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e,HttpSession session)
	{
		System.out.println(e);
		
		service.addEmp(e);
		session.setAttribute("msg","Employee Added sussefully..");
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m)
	{
		
		Employee e=service.getEmpById(id);
		
		m.addAttribute("emp",e);
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e,HttpSession session)
	{
		service.addEmp(e);
		session.setAttribute("msg", "Emp data update succefully");
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delEmp(@PathVariable int id,HttpSession session)
	{
		service.deleteEmp(id);
		session.setAttribute("msg", "Emp data delete succefully");
		return "redirect:/";
	}
	
	
	
}
