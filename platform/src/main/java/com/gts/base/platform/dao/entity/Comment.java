package com.gts.base.platform.dao.entity;

import com.gts.base.platform.dao.base.BaseEntity;

/**
 * @Description: 评定 信息 实体
 * @ClassName: Comment
 * @author gaoxiang
 * @date 2015年11月25日 上午12:01:32
 */
public class Comment extends BaseEntity {
	
	/**
	 * @Fields commentId : 评定ID
	 */
	private String commentId;
	
	/**
	 * @Fields studentId : 学生ID
	 */
	private String studentId;
	
	/**
	 * @Fields comment : 评语
	 */
	private String comment;
	
	/**
	 * @Fields certNo : 评定人
	 */
	private String commentPerson;
	
	/**
	 * @Fields gradeStage : 年级阶段
	 */
	private String gradeStage;
	
	public String getCommentId() {
		return commentId;
	}
	
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	
	public String getStudentId() {
		return studentId;
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getCommentPerson() {
		return commentPerson;
	}
	
	public void setCommentPerson(String commentPerson) {
		this.commentPerson = commentPerson;
	}
	
	public String getGradeStage() {
		return gradeStage;
	}
	
	public void setGradeStage(String gradeStage) {
		this.gradeStage = gradeStage;
	}
	
}
