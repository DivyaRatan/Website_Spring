package com.cg.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.example.demo.pojo.Employee;



@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>{

}

