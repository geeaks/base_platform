package com.gts.base.platform.dao;

import java.util.List;
import com.gts.base.platform.dao.entity.Score;

public interface ScoreDao {
	
	public int insertScore(Score score) throws Exception;
	
	public int updateScore(Score score) throws Exception;
	
	public List<Score> listPageScore(Score score) throws Exception;
	
	public List<Score> queryScore(Score score) throws Exception;
	
	public Score getScore(String scoreId) throws Exception;
	
}
