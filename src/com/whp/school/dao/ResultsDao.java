package com.whp.school.dao;

import java.util.List;

import com.whp.school.po.Results;

public interface ResultsDao {
	public List<Results> ListResults();
	public int setResults(String studentId, Integer classId, String teacherId);
	public int checkClass(String studentId, Integer classId, String teacherId);
	public int updateResults(String studentId, Integer classId, Integer results);

}
