package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Integer>
{

}
