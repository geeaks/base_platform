package com.gts.base.platform.service.impl;

import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.gts.base.platform.dao.NoticeDao;
import com.gts.base.platform.dao.entity.Notice;
import com.gts.base.platform.dao.plugin.Page;
import com.gts.base.platform.service.NoticeService;
import com.gts.base.platform.service.base.BaseService;
import com.gts.base.platform.service.bo.NoticeBo;

@Service
public class NoticeServiceImpl extends BaseService implements NoticeService {
	
	public static Logger LOGGER = Logger.getLogger(NoticeServiceImpl.class);
	
	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public int insertNotice(Notice notice) {
		int affectRow = 0;
		try {
			affectRow = noticeDao.insertNotice(notice);
		} catch (Exception e) {
			LOGGER.error("保存公告信息系统异常", e);
		}
		return affectRow;
	}
	
	@Override
	public int updateNotice(Notice notice) {
		int affectRow = 0;
		try {
			affectRow = noticeDao.insertNotice(notice);
		} catch (Exception e) {
			LOGGER.error("修改公告信息系统异常", e);
		}
		return affectRow;
	}
	
	@Override
	public List<NoticeBo> listPageNotice(Notice notice) {
		List<NoticeBo> listBo = Lists.newArrayList();
		try {
			for (Notice noticeInfo : noticeDao.listPageNotice(notice)) {
				NoticeBo noticeBo = new NoticeBo();
				BeanUtils.copyProperties(noticeBo, noticeInfo);
				listBo.add(noticeBo);
			}
		} catch (Exception e) {
			LOGGER.error("分页查询公告信息系统异常", e);
		}
		return listBo;
	}
	
	@Override
	public List<NoticeBo> queryNotice(Notice notice) {
		List<NoticeBo> listBo = Lists.newArrayList();
		try {
			for (Notice noticeInfo : noticeDao.listPageNotice(notice)) {
				NoticeBo noticeBo = new NoticeBo();
				BeanUtils.copyProperties(noticeBo, noticeInfo);
				listBo.add(noticeBo);
			}
		} catch (Exception e) {
			LOGGER.error("查询公告信息系统异常", e);
		}
		return listBo;
	}
	
	@Override
	public NoticeBo getNotice(Integer noticeId) {
		try {
			Notice notice = noticeDao.getNotice(noticeId);
			if (notice == null) {
				return null;
			}
			NoticeBo noticeBo = new NoticeBo();
			BeanUtils.copyProperties(noticeBo, notice);
			return noticeBo;
		} catch (Exception e) {
			LOGGER.error("获取公告信息系统异常", e);
		}
		return null;
	}
	
	@Override
	public Map<String, Object> listPageNotice() {
		Map<String, Object> map = Maps.newHashMap();
		Notice notice = new Notice();
		Page page = new Page();
		page.setShowCount(3);
		page.setCurrentPage(1);
		notice.setPage(page);
		List<Notice> listPageNotice;
		try {
			listPageNotice = noticeDao.listPageNotice(notice);
			map.put("success",true);
			map.put("list",listPageNotice);
		} catch (Exception e) {
			map.put("success",false);
			map.put("msg","系统异常");
			LOGGER.error("查询公告信息系统异常",e);
		}
		return map;
	}
	
}
