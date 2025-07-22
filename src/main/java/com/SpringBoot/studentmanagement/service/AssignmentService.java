package com.SpringBoot.studentmanagement.service;

import com.SpringBoot.studentmanagement.entity.Assignment;

public interface AssignmentService {
	
	public void save(Assignment assignment);
	
	public void deleteAssignmentById(int id);
}
