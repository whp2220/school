package com.whp.school;

import java.util.Scanner;


import com.whp.school.po.Admin;
import com.whp.school.view.AdminView;
import com.whp.school.view.ResultsView;
import com.whp.school.view.StudentView;
import com.whp.school.view.TeacherView;
import com.whp.school.view.impl.AdminViewImpl;
import com.whp.school.view.impl.ResultsViewImpl;
import com.whp.school.view.impl.StudentViewImpl;
import com.whp.school.view.impl.TeacherViewImpl;

public class AdminEnter {
	public static void main(String[] args) {
		new AdminEnter().work();
		
	}
	
	public void work() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("---------------------------------------------------------");
		System.out.println("|\t\t\t 学校后台管理系统 \t\t\t|");
		System.out.println("---------------------------------------------------------");
		
		AdminView adminView = new AdminViewImpl();
		StudentView studentView = new StudentViewImpl();
		TeacherView teacherView = new TeacherViewImpl();
		ResultsView resultsView = new ResultsViewImpl();
		
        Admin admin = adminView.login();
		
        if(admin!=null) {
	        int menu = 0;
	        while(menu!=6) {
		        System.out.println("\n---1.添加学生--2.添加老师--3.查询成绩--4.审核选修--5.删除无用数据--6.退出------");
			    System.out.println("请选择主菜单功能：");
			    menu = input.nextInt();
			    switch(menu) {
			        case 1:
				        studentView.saveStudent();
					    break;
				    case 2:
				    	teacherView.saveTeacher();
					    break;
				    case 3:
				    	resultsQuery();
					    break;
				    case 4:
				    	adminView.checkclass(admin);
					    break;
				    case 5:
					    System.out.println("删除无用数据");
					    break;
				    case 6:
					    System.out.println("-------------------- 欢迎下次光临 ---------------------");
					    break;	
			    }
			}
	    }else {
			System.out.println("用户名或密码输入错误！");
		}
		
	}
	
	private void resultsQuery() {
		Scanner input = new Scanner(System.in);
		
		ResultsView resultsView = new ResultsViewImpl(); 
			
		int menu = 0;
		while(menu!=4) {
			System.out.println("\n----二级菜单----1.查询所有----2.按教师工号查询----3.按学生学号查询----4.返回主菜单------");
			System.out.println("请选择二级菜单功能：");
			menu = input.nextInt();
			switch(menu) {
			    case 1:
			    	resultsView.ListResults();
				case 2:
					resultsView.ListResultsByTeacherId();
					break;
				case 3:
					resultsView.ListResultsByStudentId();
					break;
				case 4:
					break;
			}
		}
	}

}
