package com.whp.school.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.whp.school.dao.TeacherDao;
import com.whp.school.po.Teacher;
import com.whp.school.util.DBUtil;

public class TeacherDaoImpl implements TeacherDao {
	private Connection con = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	
	@Override
	public int saveTeacher(String teacherId, String teacherName) {
		int result = 0;
		String sql = "insert into teacher(teacherId,teacherName,password) values(?,?,'123')";
		try {
			con = DBUtil.getConnection();
			
			pst = con.prepareStatement(sql);
			pst.setString(1, teacherId);
			pst.setString(2, teacherName);
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
	public Teacher getTeacherByIdByPass(String teacherId, String password) {
		Teacher teacher = null;
		String sql = "select * from teacher where teacherId=? and password=?";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, teacherId);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if(rs.next()) {
				teacher = new Teacher();
				teacher.setTeacherId(rs.getString("teacherId"));
				teacher.setTeacherName(rs.getString("teacherName"));
				teacher.setPassword(rs.getString("password"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, pst, con);
		}
		return teacher;
	}

	@Override
	public int updateTeacherPassWord(String teacherId, String password) {
		int result = 0;
		String sql = "update teacher set password=? where teacherId=?";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, password);
			pst.setString(2, teacherId);
			result = pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(null, pst, con);
		}
		return result;
	}

	@Override
	public Teacher getTeacherById(String teacherId) {
		Teacher teacher = null;
		String sql = "select * from teacher where teacherId=?";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, teacherId);
			rs = pst.executeQuery();
			if(rs.next()) {
				teacher = new Teacher();
				teacher.setTeacherId(rs.getString("teacherId"));
				teacher.setTeacherName(rs.getString("teacherName"));
				teacher.setPassword(rs.getString("password"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, pst, con);
		}
		return teacher;
	}

	@Override
	public int saveClass(String className, String teacherId) {
		int result = 0;
		String sql = "insert into class values(null,?,?,1)";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, className);
			pst.setString(2, teacherId);
			result = pst.executeUpdate();
		}catch(Exception e){
			System.out.println("课程重复了");
			//e.printStackTrace();   //课程重复报错
		}finally {
			DBUtil.closeAll(null, pst, con);
		}
		return result;
	}

	@Override
	public int removeClass(Integer classId) {
		int result = 0;
		String sql = "delete from class where classId=?";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, classId);
			result = pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(null, pst, con);
		}
		return result;
	}

}
