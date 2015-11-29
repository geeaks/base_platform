package com.gts.base.platform.service;

import java.util.List;
import com.gts.base.platform.service.bo.CommentBo;

/**
 * @Description: 评论信息操作 业务处理接口
 * @ClassName: CommentService
 * @author gaoxiang
 * @date 2015年11月26日 下午10:14:02
 */ 
public interface CommentService {
	
	public int insertCommentBo(CommentBo comment) throws Exception;
	
	public int updateCommentBo(CommentBo comment) throws Exception;
	
	public List<CommentBo> listPageComment(CommentBo comment) throws Exception;
	
	public List<CommentBo> queryComment(CommentBo comment) throws Exception;
	
	public CommentBo getComment(String commentId) throws Exception;
	
}
