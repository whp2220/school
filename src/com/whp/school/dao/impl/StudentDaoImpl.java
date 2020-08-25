package com.whp.school.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.whp.school.dao.StudentDao;
import com.whp.school.po.Classes;
import com.whp.school.po.Student;
import com.whp.school.po.Teacher;
import com.whp.school.util.DBUtil;

public class StudentDaoImpl implements StudentDao{
	private Connection con = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	@Override
	public int saveStudent(String studentId, String studentName) {
		int result = 0;
		String sql = "insert into student(studentId,studentName,password) values(?,?,'123')";
		try {
			con = DBUtil.getConnection();
			
			pst = con.prepareStatement(sql);
			pst.setString(1, studentId);
			pst.setString(2, studentName);
			result = pst.executeUpdate();
			rs = pst.getGeneratedKeys();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, pst, con);	
		}
		return result;
		
	}

	@Override
	public int updateStudentPassword(String studentId, String password) {
		int result = 0;
		String sql = "update student set password=? where studentId=?";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, password);
			pst.setString(2, studentId);
			result = pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(null, pst, con);
		}
		return result;
	}

	@Override
	public Student getStudentById(String studentId) {
		Student student = null;
		String sql = "select * from student where studentId=?";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, studentId);
			rs = pst.executeQuery();
			if(rs.next()) {
				student = new Student();
				student.setStudentId(rs.getString("studentId"));
				student.setStudentName(rs.getString("studentName"));
				student.setPassword(rs.getString("password"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, pst, con);
		}
		return student;
	}

	@Override
	public Student getStudentByIdByPass(String studentId, String password) {
		Student student = null;
		String sql = "select * from student where studentId = ? and password = ?";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, studentId);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if(rs.next()) {
				student = new Student();
				student.setStudentId(rs.getString("studentId"));
				student.setStudentName(rs.getString("studentName"));
				student.setPassword(rs.getString("password"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, pst, con);
		}
		
		return student;
	}

	@Override
	public List<Student> ListStudent() {
		 List<Student> list = new ArrayList<>();
			
			String sql = "select * from student ";
			try {
				con = DBUtil.getConnection();
				pst = con.prepareStatement(sql);
				rs = pst.executeQuery();
				while(rs.next()) {
					Student student = new Student();
					student.setStudentId(rs.getString("studentId"));
					student.setStudentName(rs.getString("studentName"));
					list.add(student);
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				DBUtil.closeAll(rs, pst, con);
			}
			return list;
	}

}
