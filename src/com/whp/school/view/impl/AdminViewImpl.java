package com.whp.school.view.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

import com.whp.school.dao.AdminDao;
import com.whp.school.dao.ClassDao;
import com.whp.school.dao.ResultsDao;
import com.whp.school.dao.StudentDao;
import com.whp.school.dao.TeacherDao;
import com.whp.school.dao.impl.AdminDaoImpl;
import com.whp.school.dao.impl.ClassDaoImpl;
import com.whp.school.dao.impl.ResultsDaoImpl;
import com.whp.school.dao.impl.StudentDaoImpl;
import com.whp.school.dao.impl.TeacherDaoImpl;
import com.whp.school.po.Admin;
import com.whp.school.po.Classes;
import com.whp.school.po.Student;
import com.whp.school.util.DBUtil;
import com.whp.school.view.AdminView;

public class AdminViewImpl implements AdminView {
	@Override
	public Admin login() {
		Scanner input = new Scanner(System.in);
		//获取客户提交参数
		System.out.println("请输入管理员ID：");
		String adminName = input.next();
		System.out.println("请输入密码：");
		String password = input.next();
		//根据提交参数做业务处理
		AdminDao dao = new AdminDaoImpl();
		Admin admin = dao.getAdminByIdByPass(adminName, password);
		//输出业务返回结果
		return admin;
	}

	@Override
	public boolean checkclass(Admin admin) {
		Scanner input = new Scanner(System.in);
		ClassDao classDao = new ClassDaoImpl();
		StudentDao studentDao = new StudentDaoImpl();
		ResultsDao resultsDao = new ResultsDaoImpl();
		int result1  = 0;
		int result2  = 0;
		
		System.out.println("请确认密码");
		String inputPassword = input.next();
		String password = admin.getPassword();
		
		if(inputPassword.equals(password)) {
			List<Classes> list = classDao.ListClass();
			List<Student> listStudent = studentDao.ListStudent();
			System.out.println("\n"+ "课程编号" +"课程名称" + "\t" + "教师名称" + "\t" + "课程状态");
			for(Classes classes : list) {
				if(classes.getState() == 0) {   
					// 0是老师提交，还没审核的课程
					System.out.println(classes);
					
				}
			}
			
			System.out.println("请输入审核通过的课程Id");
			Integer classId = input.nextInt();
			for(Classes classes : list) {
				if(classes.getClassId().equals(classId)) {   
					// 只改选择的科目
					result2 = classDao.updateState(classId);
					for(Student student : listStudent) {
						result1 = resultsDao.checkClass(student.getStudentId(), classId, classes.getTeacherId());
					}
					if(result1>0 && result2>0) {
						System.out.println("审核完毕");
					}else {
						System.out.println("出错了");
					}
				}
			}
			
			return true;
			
		} else {
			System.out.println("请输入正确的密码");
			return false;
		}
		
	}
	

}
