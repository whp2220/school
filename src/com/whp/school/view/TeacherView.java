package com.whp.school.view;

import com.whp.school.po.Teacher;

public interface TeacherView {
	
	public Teacher login();
	public void saveTeacher();
	public boolean updateTeacherPassWord(String teacherId);
	public Teacher getTeacherById(String teacherId);
	public boolean saveClass(String teacherId);
	public boolean removeClass(String teacherId);
	


}
