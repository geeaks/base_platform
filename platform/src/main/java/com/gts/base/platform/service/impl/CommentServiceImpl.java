package com.gts.base.platform.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.collect.Lists;
import com.gts.base.platform.dao.CommentDao;
import com.gts.base.platform.dao.entity.Comment;
import com.gts.base.platform.service.CommentService;
import com.gts.base.platform.service.base.BaseService;
import com.gts.base.platform.service.bo.CommentBo;
import com.gts.framework.log.annotation.DigestLogAnnotated;
import com.gts.framework.log.enums.LoggerLevel;

@Service 
public class CommentServiceImpl extends BaseService implements CommentService {
	
	@Autowired
	private CommentDao commentDao;

	@Override
	@DigestLogAnnotated(digestIdentificationCode = "gts", logFileName = "DEFAULT.DIG", loggerLevel = LoggerLevel.INFO)
	public int insertCommentBo(CommentBo comment) throws Exception {
		return commentDao.insertComment(comment);
	}

	@Override
	@DigestLogAnnotated(digestIdentificationCode = "gts", logFileName = "DEFAULT.DIG", loggerLevel = LoggerLevel.INFO)
	public int updateCommentBo(CommentBo comment) throws Exception {
		return commentDao.updateComment(comment);
	}

	@Override
	@DigestLogAnnotated(digestIdentificationCode = "gts", logFileName = "DEFAULT.DIG", loggerLevel = LoggerLevel.INFO)
	public List<CommentBo> listPageComment(CommentBo commentBo) throws Exception {
		List<CommentBo> listBo = Lists.newArrayList();
		List<Comment> list = commentDao.listPageComment(commentBo);
		for(Comment comment : list){
			listBo.add((CommentBo) comment);
		}
		return listBo;
	}

	@Override
	@DigestLogAnnotated(digestIdentificationCode = "gts", logFileName = "DEFAULT.DIG", loggerLevel = LoggerLevel.INFO)
	public List<CommentBo> queryComment(CommentBo commentBo) throws Exception {
		List<CommentBo> listBo = Lists.newArrayList();
		List<Comment> list = commentDao.queryComment(commentBo);
		for(Comment comment : list){
			listBo.add((CommentBo) comment);
		}
		return listBo;
	}

	@Override
	@DigestLogAnnotated(digestIdentificationCode = "gts", logFileName = "DEFAULT.DIG", loggerLevel = LoggerLevel.INFO)
	public CommentBo getComment(String commentId) throws Exception {
		return (CommentBo) commentDao.getComment(commentId);
	}
	
}
