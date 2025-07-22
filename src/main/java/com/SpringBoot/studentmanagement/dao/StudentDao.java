package com.SpringBoot.studentmanagement.dao;

import java.util.List;

import com.SpringBoot.studentmanagement.entity.Student;

public interface StudentDao {
	
	public Student findByStudentName(String theStudentName);
	
	public void save(Student student);
	
	
	public Student findByStudentId(int id);
	
	public List<Student> findAllStudents();
	
	public void deleteById(int id);
}
