package com.SpringBoot.studentmanagement.dao;

import com.SpringBoot.studentmanagement.entity.Role;

public interface RoleDao {
	
	public Role findRoleByName(String theRoleName);
}
