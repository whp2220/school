package com.whp.school.view.impl;

import java.util.List;
import java.util.Scanner;

import com.whp.school.dao.ClassDao;
import com.whp.school.dao.TeacherDao;
import com.whp.school.dao.impl.ClassDaoImpl;
import com.whp.school.dao.impl.TeacherDaoImpl;
import com.whp.school.po.Classes;
import com.whp.school.po.Teacher;
import com.whp.school.view.TeacherView;





public class TeacherViewImpl implements TeacherView {

	@Override
	public void saveTeacher() {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入老师工号:");
		String teacherId = input.next();
		System.out.println("请输入老师姓名:");
		String teacherName = input.next();
		
		TeacherDao dao = new TeacherDaoImpl( );
		int result = dao.saveTeacher(teacherId,teacherName);
		if(result>0) {
			System.out.println("添加成功");
		}else {
			System.out.println("添加失败");
		}
	}

	@Override
	public Teacher login() {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入工号：");
		String teacherName = input.next();
		System.out.println("请输入密码：");
		String password = input.next();
		TeacherDao dao = new TeacherDaoImpl();
		Teacher teacher = dao.getTeacherByIdByPass(teacherName, password);

		return teacher;
	}
	
	@Override
	public Teacher getTeacherById(String teacherId) {
		TeacherDao dao = new TeacherDaoImpl();
		Teacher teacher = dao.getTeacherById(teacherId);
		
		return teacher;
	}

	

	@Override
	public boolean updateTeacherPassWord(String teacherId) {
		Scanner input = new Scanner(System.in);
		Teacher teacher = getTeacherById(teacherId);
		System.out.println("请输入旧密码：");
		String oldPassword = input.next();
		System.out.println("请输入新密码：");
		String newPassword = input.next();
		System.out.println("请再次输入新密码：");
		String beginNewPassword = input.next();
		
		if(!(oldPassword.equals(teacher.getPassword()))) {
			System.out.println("旧密码输入不正确！");
			return false;
		}
		if(!(newPassword.equals(beginNewPassword))) {
			System.out.println("两次输入密码不一致！");
			return false;
		}
		
		TeacherDao dao = new TeacherDaoImpl();
		int result = dao.updateTeacherPassWord(teacherId, newPassword);
		if(result>0) {
			System.out.println("更新密码成功");
		}else {
			System.out.println("更新密码失败");
		}
		return true;
		
	}

	@Override
	public boolean saveClass(String teacherId) {
		Scanner input = new Scanner(System.in);
		TeacherDao teacherDao = new TeacherDaoImpl();
		
		System.out.println("请确认密码");
		String inputPassword = input.next();
		String password = teacherDao.getTeacherById(teacherId).getPassword();
		if(inputPassword.equals(password)) {
			System.out.println("请输入要添加的课程名称");
		    String className = input.next();
		    int result = teacherDao.saveClass(className, teacherId);
		    if(result>0) {
			    System.out.println("添加成功");
		    }else {
			    System.out.println("添加失败");
		    }
		    return true;
		}else {
			System.out.println("请输入正确的密码");
			return false;
		}
		
	}

	@Override
	public boolean removeClass(String teacherId) {
		Scanner input = new Scanner(System.in);
		TeacherDao teacherDao = new TeacherDaoImpl();
		ClassDao classDao = new ClassDaoImpl();
		
		System.out.println("请确认密码");
		String inputPassword = input.next();
		String password = teacherDao.getTeacherById(teacherId).getPassword();
		if(inputPassword.equals(password)) {
			List<Classes> list = classDao.ListClass();
			System.out.println("\n"+ "课程编号" +"课程名称" + "\t" + "教师名称" + "\t" + "课程状态");
			for(Classes classes : list) {
				if(teacherId.equals(classes.getTeacherId())) {   
					// 判断是否是当前老师的课
					if(classes.getState().equals(0)) {
						// 设定state是课程状态，0为已提交未审核成功状态，老师只能删除这一状态的课程
						System.out.println(classes);
					}
					
				}
			}
			System.out.println("请输入要删除的课程编号");
			int classId = input.nextInt();
		    int result = teacherDao.removeClass(classId);
		    if(result>0) {
			    System.out.println("删除成功");
		    }else {
			    System.out.println("删除失败");
		    }
		    return true;
		}else {
			System.out.println("请输入正确的密码");
			return false;
		}
	}

	

}
