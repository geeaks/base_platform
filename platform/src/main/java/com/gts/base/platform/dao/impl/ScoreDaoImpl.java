package com.gts.base.platform.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.gts.base.platform.dao.ScoreDao;
import com.gts.base.platform.dao.base.BaseDao;
import com.gts.base.platform.dao.entity.Score;

@Repository
public class ScoreDaoImpl extends BaseDao implements ScoreDao {

	@Override
	public int insertScore(Score score) throws Exception {
		int row = this.insert("com.gts.base.platform.score.insertScore", score);
		return row;
	}

	@Override
	public int updateScore(Score score) throws Exception {
		int row = this.update("com.gts.base.platform.score.updateScore", score);
		return row;
	}

	@Override
	public List<Score> listPageScore(Score score) throws Exception {
		List<Score> list = this.queryForList("com.gts.base.platform.score.listPageScore", score);
		return list;
	}

	@Override
	public List<Score> queryScore(Score score) throws Exception {
		List<Score> list = this.queryForList("com.gts.base.platform.score.queryScore", score);
		return list;
	}

	@Override
	public Score getScore(String scoreId) throws Exception {
		Score score = this.getOne("com.gts.base.platform.score.getScore", scoreId);
		return score;
	}

}
