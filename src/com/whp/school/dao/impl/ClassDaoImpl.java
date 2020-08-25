package com.whp.school.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.whp.school.dao.ClassDao;
import com.whp.school.po.Classes;
import com.whp.school.po.Results;
import com.whp.school.util.DBUtil;

public class ClassDaoImpl implements ClassDao {
	
	private Connection con = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;


	@Override
	public List<Classes> ListClass() {
        List<Classes> list = new ArrayList<>();
		
		String sql = "select * from class c,teacher t where c.teacherId= t.teacherId order by c.teacherId ";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				Classes classes = new Classes();
				classes.setClassId(rs.getInt("classId"));
				classes.setClassName(rs.getString("ClassName"));
				classes.setTeacherId(rs.getString("TeacherId"));
				classes.setTeacherName(rs.getString("TeacherName"));
				classes.setState(rs.getInt("state"));
				list.add(classes);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, pst, con);
		}
		return list;
	}


	@Override
	public int updateState(Integer classId) {
		int result = 0;
		
		String sql = "update class set state=1 where classId=?";
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
