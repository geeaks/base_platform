package com.gts.base.platform.service;

import java.util.List;
import com.gts.base.platform.service.bo.CommentBo;

public interface CommentService {
	
	public int insertCommentBo(CommentBo comment) throws Exception;
	
	public int updateCommentBo(CommentBo comment) throws Exception;
	
	public List<CommentBo> listPageComment(CommentBo comment) throws Exception;
	
	public List<CommentBo> queryComment(CommentBo comment) throws Exception;
	
	public CommentBo getComment(String commentId) throws Exception;
	
}
