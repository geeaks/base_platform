package com.gts.base.platform.service;

import java.util.List;
import com.gts.base.platform.dao.entity.Notice;

/**
 * @Description: 公告信息 业务处理接口
 * @ClassName: NoticeDao
 * @author gaoxiang
 * @date 2015年11月25日 下午11:10:23
 */ 
public interface NoticeService {
	
	public int insertNotice(Notice notice) throws Exception;
	
	public int updateNotice(Notice notice) throws Exception;
	
	public List<Notice> listPageNotice(Notice notice) throws Exception;
	
	public List<Notice> queryNotice(Notice notice) throws Exception;
	
	public Notice getNotice(String noticeId) throws Exception;
	
}
