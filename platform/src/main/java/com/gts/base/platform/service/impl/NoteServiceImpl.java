package com.gts.base.platform.service.impl;

import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.gts.base.platform.dao.NoteDao;
import com.gts.base.platform.dao.entity.Note;
import com.gts.base.platform.dao.plugin.Page;
import com.gts.base.platform.service.NoteService;
import com.gts.base.platform.service.base.BaseService;
import com.gts.base.platform.service.bo.NoteBo;

@Service
public class NoteServiceImpl extends BaseService implements NoteService {
	
	public static Logger LOGGER = Logger.getLogger(NoteServiceImpl.class);
	
	@Autowired
	private NoteDao noteDao;
	
	@Override
	public int insertNote(Note note) {
		int affectRow = 0;
		try {
			affectRow = noteDao.insertNote(note);
		} catch (Exception e) {
			LOGGER.error("保存用户信息系统异常", e);
		}
		return affectRow;
	}
	
	@Override
	public int updateNote(Note note) {
		int affectRow = 0;
		try {
			affectRow = noteDao.insertNote(note);
		} catch (Exception e) {
			LOGGER.error("修改用户信息系统异常", e);
		}
		return affectRow;
	}
	
	@Override
	public List<NoteBo> listPageNote(Note note) {
		List<NoteBo> listBo = Lists.newArrayList();
		try {
			for (Note noteInfo : noteDao.listPageNote(note)) {
				NoteBo noteBo = new NoteBo();
				BeanUtils.copyProperties(noteBo, noteInfo);
				listBo.add(noteBo);
			}
		} catch (Exception e) {
			LOGGER.error("分页查询用户信息系统异常", e);
		}
		return listBo;
	}
	
	@Override
	public List<NoteBo> queryNote(Note note) {
		List<NoteBo> listBo = Lists.newArrayList();
		try {
			for (Note noteInfo : noteDao.listPageNote(note)) {
				NoteBo noteBo = new NoteBo();
				BeanUtils.copyProperties(noteBo, noteInfo);
				listBo.add(noteBo);
			}
		} catch (Exception e) {
			LOGGER.error("查询用户信息系统异常", e);
		}
		return listBo;
	}
	
	@Override
	public NoteBo getNote(Integer noteId) {
		try {
			Note note = noteDao.getNote(noteId);
			if (note == null) {
				return null;
			}
			NoteBo noteBo = new NoteBo();
			BeanUtils.copyProperties(noteBo, note);
			return noteBo;
		} catch (Exception e) {
			LOGGER.error("获取用户信息系统异常", e);
		}
		return null;
	}
	
	@Override
	public Map<String, Object> listPageNote(Integer userId) {
		Map<String, Object> map = Maps.newHashMap();
		Note note = new Note();
		note.setUserId(userId);
		Page page = new Page();
		page.setShowCount(3);
		page.setCurrentPage(1);
		note.setPage(page );
		List<Note> listPageNote;
		try {
			listPageNote = noteDao.listPageNote(note);
			map.put("success",true);
			map.put("list",listPageNote);
		} catch (Exception e) {
			map.put("success",false);
			map.put("msg","系统异常");
			LOGGER.error("用户【"+userId+"】查询笔记信息系统异常",e);
		}
		return map;
	}
	
}
