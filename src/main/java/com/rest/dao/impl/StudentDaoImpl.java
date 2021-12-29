package com.rest.dao.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import com.rest.dao.IStudentDao;
import com.rest.model.Student;

@Repository
public class StudentDaoImpl implements IStudentDao {
	private final String KEY = "STUDENT";

	@Resource(name = "redisTemplate")
	private HashOperations<String, Integer, Student> hashOps;

	@Override
	public void addStudent(Student s) {
		// creates new Record in hash memory if record is not present.
		hashOps.putIfAbsent(KEY, s.getStudentId(), s);
	}

	@Override
	public void modifyStudent(Student s) {
		// updates data with given id.
		hashOps.put(KEY, s.getStudentId(), s);

	}

	@Override
	public Student getOneStudent(Integer id) {
		// read one record based on HashRef and Id
		return hashOps.get(KEY, id);
	}

	@Override
	public Map<Integer, Student> getAllStudent() {
		// hashRef, get All rows as Map
		return hashOps.entries(KEY);
	}

	@Override
	public void removeStudent(Integer id) {
		hashOps.delete(KEY, id);
	}
}
