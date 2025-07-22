package com.SpringBoot.studentmanagement.dao;

import com.SpringBoot.studentmanagement.entity.Assignment;

public interface AssignmentDao {
	
	public void save(Assignment assignment);
	
	public void deleteAssignmentById(int id);
}
