package com.gts.base.platform.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.gts.base.platform.dao.CommentDao;
import com.gts.base.platform.dao.base.BaseDao;
import com.gts.base.platform.dao.entity.Comment;

@Repository
public class CommentDaoImpl extends BaseDao implements CommentDao {

	@Override
	public int insertComment(Comment comment) throws Exception {
		int row = this.insert("com.gts.base.platform.comment.insertComment", comment);
		return row;
	}

	@Override
	public int updateComment(Comment comment) throws Exception {
		int row = this.update("com.gts.base.platform.comment.updateComment", comment);
		return row;
	}

	@Override
	public List<Comment> listPageComment(Comment comment) throws Exception {
		List<Comment> list = this.queryForList("com.gts.base.platform.comment.listPageComment", comment);
		return list;
	}

	@Override
	public List<Comment> queryComment(Comment comment) throws Exception {
		List<Comment> list = this.queryForList("com.gts.base.platform.comment.queryComment", comment);
		return list;
	}

	@Override
	public Comment getComment(String commentId) throws Exception {
		Comment comment = this.getOne("com.gts.base.platform.comment.getComment", commentId);
		return comment;
	}

}
