package com.whp.school;

import java.util.Scanner;

import com.whp.school.po.Teacher;
import com.whp.school.view.ResultsView;
import com.whp.school.view.TeacherView;
import com.whp.school.view.impl.ResultsViewImpl;
import com.whp.school.view.impl.TeacherViewImpl;

public class TeacherEnter {
	public static void main(String[] args) {
		new TeacherEnter().work();
		
	}
    
    public void work() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("---------------------------------------------------------");
		System.out.println("|\t\t\t 学校后台管理系统 \t\t\t|");
		System.out.println("---------------------------------------------------------");
		
		TeacherView teacherView = new TeacherViewImpl();
		ResultsView resultsView = new ResultsViewImpl(); 
		
        Teacher teacher = teacherView.login();
		
        if(teacher!=null) {
	        int menu = 0;
	        while(menu!=5) {
		        System.out.println("\n---1.修改密码- - - 2.查询成绩- - - -3.修改成绩---4.选修管理- - -  4.退出- - - - - ");
			    System.out.println("请选择主菜单功能：");
			    menu = input.nextInt();
			    switch(menu) {
			        case 1:
			        	teacherView.updateTeacherPassWord(teacher.getTeacherId());
					    break;
				    case 2:
				    	resultsQuery();
					    break;
				    case 3:
				    	System.out.println("修改成绩");
				    	break;
				    case 4:
				    	classManager(teacher);
					    break;
				    case 5:
					    System.out.println("-------------------- 欢迎下次光临 ---------------------");
					    break;	
			    }
			}
	    }else {
			System.out.println("工号或密码输入错误！");
		}
        
	}
    
    private void classManager(Teacher teacher) {
		Scanner input = new Scanner(System.in);
		TeacherView teacherView = new TeacherViewImpl();
			
		int menu = 0;
		while(menu!=4) {
			System.out.println("\n----二级菜单----1.添加选修----2.删除选修----3.学生管理----4.返回主菜单------");
			System.out.println("请选择二级菜单功能：");
			menu = input.nextInt();
			switch(menu) {
				case 1:
					teacherView.saveClass(teacher.getTeacherId());
					break;
				case 2:
					teacherView.removeClass(teacher.getTeacherId());
					break;
				case 3:
					System.out.println("学生管理");
					break;
				case 4:
					break;
			}
		}
	}
    
    private void resultsQuery() {
		Scanner input = new Scanner(System.in);
		
		ResultsView resultsView = new ResultsViewImpl(); 
			
		int menu = 0;
		while(menu!=3) {
			System.out.println("\n----二级菜单----1.按教师工号查询----2.按学生学号查询----3.返回主菜单------");
			System.out.println("请选择二级菜单功能：");
			menu = input.nextInt();
			switch(menu) {
				case 1:
					resultsView.ListResultsByTeacherId();
					break;
				case 2:
					resultsView.ListResultsByStudentId();
					break;
				case 3:
					break;
			}
		}
	}
    
}


