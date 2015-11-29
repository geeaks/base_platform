package com.gts.base.platform.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.gts.base.platform.dao.NoteDao;
import com.gts.base.platform.dao.base.BaseDao;
import com.gts.base.platform.dao.entity.Note;

@Repository
public class NoteDaoImpl extends BaseDao implements NoteDao {

	@Override
	public int insertNote(Note note) throws Exception {
		int row = this.insert("com.gts.base.platform.note.insertNote", note);
		return row;
	}

	@Override
	public int updateNote(Note note) throws Exception {
		int row = this.update("com.gts.base.platform.note.updateNote", note);
		return row;
	}

	@Override
	public List<Note> listPageNote(Note note) throws Exception {
		List<Note> list = this.queryForList("com.gts.base.platform.note.listPageNote", note);
		return list;
	}

	@Override
	public List<Note> queryNote(Note note) throws Exception {
		List<Note> list = this.queryForList("com.gts.base.platform.note.queryNote", note);
		return list;
	}

	@Override
	public Note getNote(Integer noteId) throws Exception {
		Note note = this.getOne("com.gts.base.platform.note.getNote", noteId);
		return note;
	}

}
