package com.SpringBoot.studentmanagement.config;

import com.SpringBoot.studentmanagement.dao.StudentDao;
import com.SpringBoot.studentmanagement.dao.TeacherDao;
import com.SpringBoot.studentmanagement.entity.Student;
import com.SpringBoot.studentmanagement.entity.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Student student = studentDao.findByStudentName(username);
        if (student != null) {
            return new org.springframework.security.core.userdetails.User(
                    student.getUserName(),
                    student.getPassword(),
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_STUDENT")));
        }

        Teacher teacher = teacherDao.findByTeacherName(username);
        if (teacher != null) {
            return new org.springframework.security.core.userdetails.User(
                    teacher.getUserName(),
                    teacher.getPassword(),
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_TEACHER")));
        }

        throw new UsernameNotFoundException("User not found");
    }
}
