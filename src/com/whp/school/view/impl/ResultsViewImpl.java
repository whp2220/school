package com.whp.school.view.impl;

import java.util.List;
import java.util.Scanner;

import com.whp.school.dao.ResultsDao;
import com.whp.school.dao.StudentDao;
import com.whp.school.dao.TeacherDao;
import com.whp.school.dao.impl.ResultsDaoImpl;
import com.whp.school.dao.impl.StudentDaoImpl;
import com.whp.school.dao.impl.TeacherDaoImpl;
import com.whp.school.po.Results;
import com.whp.school.po.Student;
import com.whp.school.po.Teacher;
import com.whp.school.view.ResultsView;

public class ResultsViewImpl implements ResultsView{
	
	@Override
	public void ListResults() {
		Scanner input = new Scanner(System.in);
		
		ResultsDao dao = new ResultsDaoImpl();
		List<Results> list = dao.ListResults();
		System.out.println("\n学生姓名\t课程名称\t教师姓名\t成绩");
		for(Results results : list) {
			    System.out.println(results);
		}
	}
	
	@Override
	public void ListResultsByTeacherId() {
		Scanner input = new Scanner(System.in);
		TeacherDao teacherDao = new TeacherDaoImpl();
		
		System.out.println("请输入要查询教师的工号");
		String id = input.next();
		Teacher teacher = teacherDao.getTeacherById(id);
		
		ResultsDao dao = new ResultsDaoImpl();
		List<Results> list = dao.ListResults();
		System.out.println("\n学生姓名\t课程名称\t教师姓名\t成绩");
		for(Results results : list) {
			if(results.getTeacherName().equals(teacher.getTeacherName())) {
				System.out.println(results);
			}  
		}
	}
	
	@Override
	public void ListResultsByStudentId() {
		Scanner input = new Scanner(System.in);
		StudentDao studentDao = new StudentDaoImpl();
		
		System.out.println("请输入要查询学生的学号");
		String id = input.next();
		Student student = studentDao.getStudentById(id);
		
		ResultsDao dao = new ResultsDaoImpl();
		List<Results> list = dao.ListResults();
		System.out.println("\n学生姓名\t课程名称\t教师姓名\t成绩");
		for(Results results : list) {
			if(results.getStudentName().equals(student.getStudentName())) {
				System.out.println(results);
			}
		}
	}

}
