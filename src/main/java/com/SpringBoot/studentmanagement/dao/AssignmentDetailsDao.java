package com.SpringBoot.studentmanagement.dao;

import com.SpringBoot.studentmanagement.entity.AssignmentDetails;

public interface AssignmentDetailsDao {
	
	public AssignmentDetails findByAssignmentAndStudentCourseDetailsId(int assignmentId, int studentCourseDetailsId);
	
	public void save(AssignmentDetails studentCourseAssignmentDetails);
}
