package com.gts.base.platform.service;

import java.util.List;
import com.gts.base.platform.dao.entity.Score;

/**
 * @Description: 评定 信息业务处理接口
 * @ClassName: ScoreDao
 * @author gaoxiang
 * @date 2015年11月25日 下午11:11:48
 */ 
public interface ScoreService {
	
	public int insertScore(Score score) throws Exception;
	
	public int updateScore(Score score) throws Exception;
	
	public List<Score> listPageScore(Score score) throws Exception;
	
	public List<Score> queryScore(Score score) throws Exception;
	
	public Score getScore(String scoreId) throws Exception;
	
}
