package com.gts.base.platform.dao.entity;

import com.gts.base.platform.dao.base.BaseDao;
import com.gts.base.platform.dao.plugin.Page;

/**
 * @Description: 通告信息实体
 * @ClassName: Notice
 * @author gaoxiang
 * @date 2015年11月29日 下午3:00:19
 */
public class Notice extends BaseDao {
	
	/**
	 * @Fields noticeId : 通告ID
	 */
	private Integer noticeId;
	
	/**
	 * @Fields noticeType : 通告类型
	 */
	private String noticeType;
	
	/**
	 * @Fields noticeTitle : 通告标题
	 */
	private String noticeTitle;
	
	/**
	 * @Fields noticeContent : 通告内容
	 */
	private String noticeContent;
	
	private Page page;
	
	public Integer getNoticeId() {
		return noticeId;
	}
	
	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}
	
	public String getNoticeType() {
		return noticeType;
	}
	
	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}
	
	public String getNoticeTitle() {
		return noticeTitle;
	}
	
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	
	public String getNoticeContent() {
		return noticeContent;
	}
	
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	
	public Page getPage() {
		return page;
	}
	
	public void setPage(Page page) {
		this.page = page;
	}
	
}
