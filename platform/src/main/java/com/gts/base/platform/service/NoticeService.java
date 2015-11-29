package com.gts.base.platform.service;

import java.util.List;
import java.util.Map;
import com.gts.base.platform.dao.entity.Notice;
import com.gts.base.platform.service.bo.NoticeBo;

/**
 * @Description: 公告信息 业务处理接口
 * @ClassName: NoticeDao
 * @author gaoxiang
 * @date 2015年11月25日 下午11:10:23
 */ 
public interface NoticeService {
	
	public int insertNotice(Notice notice);
	
	public int updateNotice(Notice notice);
	
	public List<NoticeBo> listPageNotice(Notice notice);
	
	public List<NoticeBo> queryNotice(Notice notice);
	
	public NoticeBo getNotice(Integer noticeId);

	public Map<String, Object> listPageNotice();
	
}
