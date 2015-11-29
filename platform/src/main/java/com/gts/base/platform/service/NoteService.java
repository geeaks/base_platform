package com.gts.base.platform.service;

import java.util.List;
import com.gts.base.platform.dao.entity.Note;

/**
 * @Description: 公告信息 业务处理接口
 * @ClassName: NoteDao
 * @author gaoxiang
 * @date 2015年11月25日 下午11:10:23
 */ 
public interface NoteService {
	
	public int insertNote(Note note) throws Exception;
	
	public int updateNote(Note note) throws Exception;
	
	public List<Note> listPageNote(Note note) throws Exception;
	
	public List<Note> queryNote(Note note) throws Exception;
	
	public Note getNote(String noteId) throws Exception;
	
}
