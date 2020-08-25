package com.whp.school.po;

public class Classes {
	private Integer classId;
	private String className;
	private String teacherId;
	private String teacherName;
	private Integer state;
	
	@Override
	public String toString() {
		
		return "\n"+ this.classId + "\t" + this.className + "\t" + this.teacherName+ "\t" + this.state;
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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
	
	
	
	
}
