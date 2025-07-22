package com.SpringBoot.studentmanagement.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.SpringBoot.studentmanagement.entity.Student;
import com.SpringBoot.studentmanagement.user.UserDto;

public interface StudentService {
	
	public Student findByStudentName(String userName);

	public void save(UserDto userDto);
	
	public void save(Student student);
	
	public Student findByStudentId(int id);
	
	public List<Student> findAllStudents();
	
	public void deleteById(int id);
}
