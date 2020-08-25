package com.whp.school.dao;

import java.util.List;

import com.whp.school.po.Student;

public interface StudentDao {
	public int saveStudent(String studentId, String studentName);
	public Student getStudentById(String studentId);
	public int updateStudentPassword(String studentId, String password);
	public Student getStudentByIdByPass(String studentId, String password);
	public List<Student> ListStudent ();

}
