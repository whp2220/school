package com.whp.school;

import java.util.Scanner;

import com.whp.school.po.Student;
import com.whp.school.view.ResultsView;
import com.whp.school.view.StudentView;
import com.whp.school.view.impl.ResultsViewImpl;
import com.whp.school.view.impl.StudentViewImpl;

public class StudentEnter {
	
	public static void main(String[] args) {
		new StudentEnter().work();
		
	}
	
	public void work() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("---------------------------------------------------------");
		System.out.println("|\t\t\t 学校后台管理系统 \t\t\t|");
		System.out.println("---------------------------------------------------------");
		
		StudentView studentView = new StudentViewImpl();
		ResultsView resultsView = new ResultsViewImpl(); 
		
		Student student = studentView.login();
		
	    if(student!=null) {
	        int menu = 0;
	        while(menu!=4) {
		        System.out.println("\n---1.修改密码- - - - - 2.查询成绩- - - - - 3.选修报名- - - - - 4.退出- - - - - ");
			    System.out.println("请选择主菜单功能：");
			    menu = input.nextInt();
			    switch(menu) {
			        case 1:
			        	studentView.updateStudentPassword(student.getStudentId());
					    break;
				    case 2:
				    	resultsView.ListResults();
					    break;
				    case 3:
				    	studentView.signUpClass(student);
					    break;
				    case 4:
					    System.out.println("-------------------- 欢迎下次光临 ---------------------");
					    break;	
			    }
			}
	    }else {
			System.out.println("学号或密码输入错误！");
		}
	}

	
}

