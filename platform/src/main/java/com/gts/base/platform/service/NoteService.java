package com.gts.base.platform.service;

import java.util.List;
import java.util.Map;
import com.gts.base.platform.dao.entity.Note;
import com.gts.base.platform.service.bo.NoteBo;

/**
 * @Description: 我的记事信息 业务处理接口
 * @ClassName: NoteDao
 * @author gaoxiang
 * @date 2015年11月25日 下午11:10:23
 */ 
public interface NoteService {
	
	public int insertNote(Note note);
	
	public int updateNote(Note note);
	
	public List<NoteBo> listPageNote(Note note);
	
	public List<NoteBo> queryNote(Note note);
	
	public NoteBo getNote(Integer noteId);

	public Map<String, Object> listPageNote(Integer userId);
	
}
