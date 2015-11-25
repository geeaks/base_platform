package com.gts.base.platform.service.bo;

/**
 * @Description: 家长-学生 关联关系实体 多对多
 * @ClassName: GenearchStudent
 * @author gaoxiang
 * @date 2015年11月24日 下午11:56:31
 */
public class GenearchStudentBo {
	
	/**
	 * @Fields id : 主键
	 */
	private String id;
	
	/**
	 * @Fields teacherId : 家长ID
	 */
	private String genearchId;
	
	/**
	 * @Fields studentId : 学生ID
	 */
	private String studentId;
	
	/**
	 * @Fields valid : 是否可用
	 */
	private String valid;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getGenearchId() {
		return genearchId;
	}
	
	public void setGenearchId(String genearchId) {
		this.genearchId = genearchId;
	}
	
	public String getStudentId() {
		return studentId;
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public String getValid() {
		return valid;
	}
	
	public void setValid(String valid) {
		this.valid = valid;
	}
	
}
