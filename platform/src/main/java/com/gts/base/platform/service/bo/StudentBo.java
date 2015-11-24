package com.gts.base.platform.service.bo;

import com.gts.base.platform.dao.base.BaseEntity;

/**
 * @Description: 学生信息实体
 * @ClassName: Student
 * @author gaoxiang
 * @date 2015年11月24日 下午11:01:57
 */
public class StudentBo extends BaseEntity {
	
	/**
	 * @Fields studentId : 学生ID
	 */
	private String studentId;
	
	/**
	 * @Fields userId : 用户ID
	 */
	private String userId;
	
	/**
	 * @Fields school : 学校
	 */
	private String school;
	
	/**
	 * @Fields major : 专业
	 */
	private String major;
	
	/**
	 * @Fields grade : 年级
	 */
	private String grade;
	
	/**
	 * @Fields gradeStage : 年级阶段
	 */
	private String gradeStage;
	
	/**
	 * @Fields classes : 班次
	 */
	private String classes;
	
	/**
	 * @Fields level : 级别
	 */
	private String level;
	
	public String getStudentId() {
		return studentId;
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getSchool() {
		return school;
	}
	
	public void setSchool(String school) {
		this.school = school;
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public String getGrade() {
		return grade;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public String getGradeStage() {
		return gradeStage;
	}
	
	public void setGradeStage(String gradeStage) {
		this.gradeStage = gradeStage;
	}
	
	public String getClasses() {
		return classes;
	}
	
	public void setClasses(String classes) {
		this.classes = classes;
	}
	
	public String getLevel() {
		return level;
	}
	
	public void setLevel(String level) {
		this.level = level;
	}
	
}
