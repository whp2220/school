package com.whp.school.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import com.whp.school.dao.AdminDao;
import com.whp.school.po.Admin;
import com.whp.school.util.DBUtil;

public class AdminDaoImpl implements AdminDao {
	private Connection con = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	@Override
	public Admin getAdminByIdByPass(String adminId, String password) {
		Admin admin = null;
		String sql = "select * from admin where adminId=? and password=?";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, adminId);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if(rs.next()) {
				admin = new Admin();
				admin.setAdminId(rs.getString("adminId"));
				admin.setAdminName(rs.getString("adminName"));
				admin.setPassword(rs.getString("password"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, pst, con);
		}
		return admin;
	}
	
}
