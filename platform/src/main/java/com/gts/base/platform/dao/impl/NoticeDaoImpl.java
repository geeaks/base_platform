package com.gts.base.platform.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.gts.base.platform.dao.NoticeDao;
import com.gts.base.platform.dao.base.BaseDao;
import com.gts.base.platform.dao.entity.Notice;

@Repository
public class NoticeDaoImpl extends BaseDao implements NoticeDao {

	@Override
	public int insertNotice(Notice notice) throws Exception {
		int row = this.insert("com.gts.base.platform.notice.insertNotice", notice);
		return row;
	}

	@Override
	public int updateNotice(Notice notice) throws Exception {
		int row = this.update("com.gts.base.platform.notice.updateNotice", notice);
		return row;
	}

	@Override
	public List<Notice> listPageNotice(Notice notice) throws Exception {
		List<Notice> list = this.queryForList("com.gts.base.platform.notice.listPageNotice", notice);
		return list;
	}

	@Override
	public List<Notice> queryNotice(Notice notice) throws Exception {
		List<Notice> list = this.queryForList("com.gts.base.platform.notice.queryNotice", notice);
		return list;
	}

	@Override
	public Notice getNotice(Integer noticeId) throws Exception {
		Notice notice = this.getOne("com.gts.base.platform.notice.getNotice", noticeId);
		return notice;
	}

}
