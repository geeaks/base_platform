package com.gts.base.platform.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.gts.base.platform.dao.GenearchDao;
import com.gts.base.platform.dao.base.BaseDao;
import com.gts.base.platform.dao.entity.Genearch;

@Repository
public class GenearchDaoImpl extends BaseDao implements GenearchDao {

	@Override
	public int insertGenearch(Genearch genearch) throws Exception {
		int row = this.insert("com.gts.base.platform.genearch.insertGenearch", genearch);
		return row;
	}

	@Override
	public int updateGenearch(Genearch genearch) throws Exception {
		int row = this.update("com.gts.base.platform.genearch.updateGenearch", genearch);
		return row;
	}

	@Override
	public List<Genearch> listPageGenearch(Genearch genearch) throws Exception {
		List<Genearch> list = this.queryForList("com.gts.base.platform.genearch.listPageGenearch", genearch);
		return list;
	}

	@Override
	public List<Genearch> queryGenearch(Genearch genearch) throws Exception {
		List<Genearch> list = this.queryForList("com.gts.base.platform.genearch.queryGenearch", genearch);
		return list;
	}

	@Override
	public Genearch getGenearch(String genearchId) throws Exception {
		Genearch genearch = this.getOne("com.gts.base.platform.genearch.getGenearch", genearchId);
		return genearch;
	}

}
