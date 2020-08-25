package com.whp.school.dao;

import com.whp.school.po.Admin;

public interface AdminDao {
	public Admin getAdminByIdByPass (String adminId,String password);
	

}
