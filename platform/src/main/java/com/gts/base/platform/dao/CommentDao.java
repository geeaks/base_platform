package com.gts.base.platform.dao;

import java.util.List;
import com.gts.base.platform.dao.entity.Comment;

public interface CommentDao {
	
	public int insertComment(Comment comment) throws Exception;
	
	public int updateComment(Comment comment) throws Exception;
	
	public List<Comment> listPageComment(Comment comment) throws Exception;
	
	public List<Comment> queryComment(Comment comment) throws Exception;
	
	public Comment getComment(String commentId) throws Exception;
	
}
