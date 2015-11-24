package com.gts.base.platform.service.bo;

/**
 * @Description: 教师-学生 关联关系实体 多对多
 * @ClassName: TeacherStudent
 * @author gaoxiang
 * @date 2015年11月24日 下午11:01:57
 */
public class TeacherStudentBo {
	
	/**
	 * @Fields id : 主键
	 */
	private String id;
	
	/**
	 * @Fields teacherId : 教师ID
	 */
	private String teacherId;
	
	/**
	 * @Fields studentId : 学生ID
	 */
	private String studentId;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTeacherId() {
		return teacherId;
	}
	
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	
	public String getStudentId() {
		return studentId;
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
}
