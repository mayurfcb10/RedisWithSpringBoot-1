package com.rest.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rest.dao.IStudentDao;
import com.rest.model.Student;

@Component
public class RedisOprTest implements CommandLineRunner {
	
	@Autowired
	private IStudentDao dao;

	@Override
	public void run(String... args) throws Exception {
		dao.addStudent( new Student(101,"Mark",300.5));
		dao.addStudent(new Student(102,"Bill",450.0));
		dao.addStudent(new Student(103,"Warren",600.0));
		
		dao.getAllStudent().forEach((k,v) -> System.out.println(k +" =>  "+ v));
		dao.modifyStudent(new Student(105,"Jake",550.0));
		dao.removeStudent(101);
		System.out.println("*******--------------After Remove / Modify ------------------*************");
		dao.getAllStudent().forEach((k,v) -> System.out.println(k +" =>  "+ v));
	}
	

}
