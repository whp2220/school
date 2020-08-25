package com.whp.school.po;

public class Results {
	private String studentId;
	private String studentName;
	private Integer classId;
	private String className;
	private String teacherId;
	private String teacherName;
	private Integer results;
	
	
	@Override
	public String toString() {
		
		return "\n"+ this.studentName + "\t" + this.className + "\t" + this.teacherName+ "\t" + this.results;
	}


	public String getStudentId() {
		return studentId;
	}


	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public Integer getClassId() {
		return classId;
	}


	public void setClassId(Integer classId) {
		this.classId = classId;
	}


	public String getClassName() {
		return className;
	}


	public void setClassName(String className) {
		this.className = className;
	}


	public String getTeacherId() {
		return teacherId;
	}


	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}


	public String getTeacherName() {
		return teacherName;
	}


	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}


	public Integer getResults() {
		return results;
	}


	public void setResults(Integer results) {
		this.results = results;
	}
	
	
	
}
