package com.SpringBoot.studentmanagement.service;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SpringBoot.studentmanagement.dao.RoleDao;
import com.SpringBoot.studentmanagement.dao.StudentDao;
import com.SpringBoot.studentmanagement.entity.Role;
import com.SpringBoot.studentmanagement.entity.Student;
import com.SpringBoot.studentmanagement.user.UserDto;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;
	
	@Autowired 
	private RoleDao roleDao;
	

	@Override
	@Transactional
	public Student findByStudentName(String studentName) {
		return studentDao.findByStudentName(studentName);
	}
	
	@Override
	@Transactional
	public Student findByStudentId(int id) {
		return studentDao.findByStudentId(id);
	}

	@Override
	@Transactional
	public void save(UserDto userDto) {
		Student student = new Student();
		student.setUserName(userDto.getUserName());
		student.setPassword(new BCryptPasswordEncoder().encode(userDto.getPassword()));
		student.setFirstName(userDto.getFirstName());
		student.setLastName(userDto.getLastName());
		student.setEmail(userDto.getEmail());		
		student.setRole(userDto.getRole());	
		
		studentDao.save(student);
	}

	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public List<Student> findAllStudents() {
		return studentDao.findAllStudents();
	}

	@Override
	@Transactional
	public void save(Student student) {
		studentDao.save(student);
		
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		studentDao.deleteById(id);
	}

}
