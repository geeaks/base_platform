package com.gts.base.platform.dao;

import java.util.List;
import com.gts.base.platform.dao.entity.Comment;

/**
 * @Description: 学生评语 数据访问接口
 * @ClassName: CommentDao
 * @author gaoxiang
 * @date 2015年11月25日 下午11:01:42
 */ 
public interface CommentDao {
	
	public int insertComment(Comment comment) throws Exception;
	
	public int updateComment(Comment comment) throws Exception;
	
	public List<Comment> listPageComment(Comment comment) throws Exception;
	
	public List<Comment> queryComment(Comment comment) throws Exception;
	
	public Comment getComment(String commentId) throws Exception;
	
}
