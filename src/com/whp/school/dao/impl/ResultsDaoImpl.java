package com.whp.school.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.whp.school.dao.ResultsDao;
import com.whp.school.po.Results;
import com.whp.school.util.DBUtil;


public class ResultsDaoImpl implements ResultsDao{
	
	private Connection con = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	@Override
	public List<Results> ListResults() {
		List<Results> list = new ArrayList<>();
		
		String sql = "select * from results r,student s,class c,teacher t where r.studentId=s.studentId and r.classId=c.classId and r.teacherId= t.teacherId order by r.studentId ";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				Results results = new Results();
				results.setClassId(rs.getInt("classId"));
				results.setStudentId(rs.getString("studentId"));
				results.setStudentName(rs.getString("studentName"));
				results.setClassName(rs.getString("className"));
				results.setTeacherName(rs.getString("teacherName"));
				results.setResults(rs.getInt("results"));
				list.add(results);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, pst, con);
		}
		return list;
	}

	@Override
	public int setResults(String studentId, Integer classId, String teacherId) {
		int result = 0;
		String sql = "insert into results set studentId=?, classId=?,  teacherId=?, state=101n   where studentId=?";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, studentId);
			pst.setInt(2, classId);
			pst.setString(1, teacherId);
			pst.setString(1, studentId);
			result = pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(null, pst, con);
		}
		return result;
	}
	
	@Override
	public int checkClass(String studentId, Integer classId, String teacherId) {
		int result = 0;
		String sql = "insert into results(studentId,classId,teacherId,results) values(?,?,?,'101')"; //默认分数101，表示还没选课
		try {
			con = DBUtil.getConnection();
			
			pst = con.prepareStatement(sql);
			pst.setString(1, studentId);
			pst.setInt(2, classId);
			pst.setString(3, teacherId);
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
	public int updateResults(String studentId, Integer classId, Integer results) {
        int result = 0;
		
		String sql = "update results set results=?  where  studentId=? and classId=?";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, results);
			pst.setString(2, studentId);
			pst.setInt(3, classId);
            
			result = pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(null, pst, con);
		}
		
		return result;
	}

}
