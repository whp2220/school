package com.whp.school.view.impl;

import java.util.List;
import java.util.Scanner;

import com.whp.school.dao.ResultsDao;
import com.whp.school.dao.StudentDao;
import com.whp.school.dao.impl.ResultsDaoImpl;
import com.whp.school.dao.impl.StudentDaoImpl;
import com.whp.school.po.Results;
import com.whp.school.po.Student;
import com.whp.school.view.StudentView;

public class StudentViewImpl implements StudentView {

	@Override
	public void saveStudent() {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入学生学号:");
		String studentId = input.next();
		System.out.println("请输入学生姓名:");
		String studentName = input.next();
		
		StudentDao dao = new StudentDaoImpl( );
		int result = dao.saveStudent(studentId,studentName);
		if(result>0) {
			System.out.println("添加成功");
		}else {
			System.out.println("添加失败");
		}
		
	}

	@Override
	public void updateStudentPassword(String studentId) {
		Scanner input = new Scanner(System.in);
		Student student = getStudentById(studentId);
		System.out.println("请输入旧密码：");
		String oldPassword = input.next();
		System.out.println("请输入新密码：");
		String newPassword = input.next();
		System.out.println("请再次输入新密码：");
		String beginNewPassword = input.next();
		
		if(!(oldPassword.equals(student.getPassword()))) {
			System.out.println("旧密码输入不正确！");
			return ;
		}
		if(!(newPassword.equals(beginNewPassword))) {
			System.out.println("两次输入密码不一致！");
			return ;
		}
		
		StudentDao dao = new StudentDaoImpl();
		int result = dao.updateStudentPassword(studentId, newPassword);
		if(result>0) {
			System.out.println("更新密码成功");
		}else {
			System.out.println("更新密码失败");
		}
		return ;
		
	}

	@Override
	public Student getStudentById(String studentId) {
		StudentDao studentDao = new StudentDaoImpl();
		Student student = studentDao.getStudentById(studentId);
		
		return student;
	}

	@Override
	public Student login() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("请输入学号：");
		String studentName = input.next();
		System.out.println("请输入密码：");
		String password = input.next();
		StudentDao dao = new StudentDaoImpl();
		Student  student = dao.getStudentByIdByPass(studentName, password);

		return  student;
	}

	@Override
	public void signUpClass(Student student) {
		Scanner input = new Scanner(System.in);
		ResultsDao resultsDao = new ResultsDaoImpl();
		
		List<Results> list = resultsDao.ListResults();
		System.out.println("\n"+ "学生姓名" +"\t"+"课程编号"+"\t"+"课程名称" + "\t" + "教师姓名" + "\t" + "状态");
		for(Results results : list) {
			if(results.getResults() == 101) {   
				// 101代表还没选
				if(results.getStudentId().equals(student.getStudentId())) {
					// 判断是不是自己的成绩
					System.out.println("\n"+ results.getStudentName() + "\t" +results.getClassId()+"\t"+ results.getClassName() + "\t" + results.getTeacherName()+ "\t" + "可报名");
				}
				
			}
		}
		System.out.println("请输入要报名的课程编号");
		int classId = input.nextInt();
		String studentId = student.getStudentId();
	    int result = resultsDao.updateResults(studentId, classId, 102); //102代表已报名
	    if(result>0) {
		    System.out.println("报名成功");
	    }else {
		    System.out.println("报名失败");
	    }

		
	}

	

}
