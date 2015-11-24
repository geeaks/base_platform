package com.gts.base.platform.dao.entity;

import com.gts.base.platform.dao.base.BaseEntity;

/**
 * @Description: 成绩信息实体
 * @ClassName: Score
 * @author gaoxiang
 * @date 2015年11月24日 下午11:01:57
 */
public class Score extends BaseEntity {
	
	/**
	 * @Fields scoreId : 成绩信息 主键
	 */
	private String scoreId;
	
	/**
	 * @Fields studentId : 学生ID
	 */
	private String studentId;
	
	/**
	 * @Fields teacherId : 评分老师ID
	 */
	private String teacherId;
	
	/**
	 * @Fields subject : 科目
	 */
	private String subject;
	
	/**
	 * @Fields score : 分数
	 */
	private String score;
	
	/**
	 * @Fields gradeStage : 年级阶段
	 */
	private String gradeStage;
	
	public String getScoreId() {
		return scoreId;
	}
	
	public void setScoreId(String scoreId) {
		this.scoreId = scoreId;
	}
	
	public String getStudentId() {
		return studentId;
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public String getTeacherId() {
		return teacherId;
	}
	
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getScore() {
		return score;
	}
	
	public void setScore(String score) {
		this.score = score;
	}
	
	public String getGradeStage() {
		return gradeStage;
	}
	
	public void setGradeStage(String gradeStage) {
		this.gradeStage = gradeStage;
	}
	
}
