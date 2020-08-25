package com.whp.school.view;

import com.whp.school.po.Student;

public interface StudentView {
	public void saveStudent();
	public void updateStudentPassword(String studendId);
	public Student getStudentById(String studentId);
	public Student login();
	public void signUpClass(Student student);

}
