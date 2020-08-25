package com.whp.school.dao;

import java.util.List;

import com.whp.school.po.Classes;

public interface ClassDao {
	public List<Classes> ListClass();
	public int updateState(Integer classId);

}
