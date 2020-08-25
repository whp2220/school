package com.whp.school.dao;

import com.whp.school.po.Teacher;

public interface TeacherDao {
	
	public int saveTeacher(String teacherId, String teacherName);
	public Teacher getTeacherByIdByPass (String teacherId,String password);
	public Teacher getTeacherById(String teacherId);
	public int updateTeacherPassWord(String TeacherId,String password);
	public int saveClass(String className, String teacherId);
	public int removeClass(Integer classId);
	
	
	
}
