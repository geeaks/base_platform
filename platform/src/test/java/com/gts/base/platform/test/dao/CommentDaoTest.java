package com.gts.base.platform.test.dao;

import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSON;
import com.gts.base.platform.dao.CommentDao;
import com.gts.base.platform.dao.entity.Comment;
import com.gts.base.platform.dao.plugin.util.Page;
import com.gts.base.platform.test.BaseTest;

public class CommentDaoTest extends BaseTest {
	
	@Autowired
	private CommentDao commentDao;
	
	@Test
	public void insertComment(){
		Comment comment = new Comment();
		comment.setCommentId(1);
		comment.setComment("SDD");
		try {
			int rows = commentDao.insertComment(comment);
			System.err.println(rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
	@Test
	public void listPageComment(){
		Page page = new Page();
		
		page.setCurrentPage(1);
		page.setShowCount(3);
		
		Comment comment = new Comment();
		comment.setComment("SDD");
		comment.setPage(page);
		try {
			List<Comment> list = commentDao.listPageComment(comment);
			System.err.println(JSON.toJSONString(comment.getPage()));
			System.err.println(JSON.toJSONString(list));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
