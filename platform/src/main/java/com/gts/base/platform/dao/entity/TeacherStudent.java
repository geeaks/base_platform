package com.gts.base.platform.dao.entity;

/**
 * @Description: 教师-学生 关联关系实体 多对多
 * @ClassName: TeacherStudent
 * @author gaoxiang
 * @date 2015年11月24日 下午11:01:57
 */
public class TeacherStudent {
	
	/**
	 * @Fields id : 主键
	 */
	private Integer id;
	
	/**
	 * @Fields teacherId : 教师ID
	 */
	private Integer teacherId;
	
	/**
	 * @Fields studentId : 学生ID
	 */
	private Integer studentId;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getTeacherId() {
		return teacherId;
	}
	
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	
	public Integer getStudentId() {
		return studentId;
	}
	
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	
}
