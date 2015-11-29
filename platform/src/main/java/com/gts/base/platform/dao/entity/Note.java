package com.gts.base.platform.dao.entity;

import com.gts.base.platform.dao.base.BaseEntity;

/**
 * @Description: 笔记信息 实体
 * @ClassName: Note
 * @author gaoxiang
 * @date 2015年11月24日 下午11:53:56
 */
public class Note extends BaseEntity {
	
	/**
	 * @Fields noteId : 笔记ID
	 */
	private Integer noteId;
	
	/**
	 * @Fields userId : 用户ID
	 */
	private Integer userId;
	
	/**
	 * @Fields noteName : 笔记名称
	 */ 
	private String noteName;
	
	/**
	 * @Fields noteContent : 笔记内容
	 */ 
	private String noteContent;
	
	public Integer getNoteId() {
		return noteId;
	}
	
	public void setNoteId(Integer noteId) {
		this.noteId = noteId;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getNoteName() {
		return noteName;
	}
	
	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}
	
	public String getNoteContent() {
		return noteContent;
	}
	
	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}
	
}
