package com.gts.base.platform.dao;

import java.util.List;
import com.gts.base.platform.dao.entity.Notice;

/**
 * @Description: 公告信息 数据访问接口
 * @ClassName: NoticeDao
 * @author gaoxiang
 * @date 2015年11月25日 下午11:10:23
 */ 
public interface NoticeDao {
	
	public int insertNotice(Notice notice) throws Exception;
	
	public int updateNotice(Notice notice) throws Exception;
	
	public List<Notice> listPageNotice(Notice notice) throws Exception;
	
	public List<Notice> queryNotice(Notice notice) throws Exception;
	
	public Notice getNotice(Integer noticeId) throws Exception;
	
}
