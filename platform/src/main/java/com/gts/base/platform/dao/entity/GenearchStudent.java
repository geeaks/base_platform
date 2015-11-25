package com.gts.base.platform.dao.entity;

/**
 * @Description: 家长-学生 关联关系实体 多对多
 * @ClassName: GenearchStudent
 * @author gaoxiang
 * @date 2015年11月24日 下午11:56:31
 */
public class GenearchStudent {
	
	/**
	 * @Fields id : 主键
	 */
	private Integer id;
	
	/**
	 * @Fields teacherId : 家长ID
	 */
	private Integer genearchId;
	
	/**
	 * @Fields studentId : 学生ID
	 */
	private Integer studentId;
	
	/**
	 * @Fields valid : 是否可用
	 */
	private String valid;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getGenearchId() {
		return genearchId;
	}
	
	public void setGenearchId(Integer genearchId) {
		this.genearchId = genearchId;
	}
	
	public Integer getStudentId() {
		return studentId;
	}
	
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	
	public String getValid() {
		return valid;
	}
	
	public void setValid(String valid) {
		this.valid = valid;
	}
	
}
