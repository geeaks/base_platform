package com.gts.base.platform.dao;

import java.util.List;
import com.gts.base.platform.dao.entity.Genearch;

public interface GenearchDao {
	
	public int insertGenearch(Genearch genearch) throws Exception;
	
	public int updateGenearch(Genearch genearch) throws Exception;
	
	public List<Genearch> listPageGenearch(Genearch genearch) throws Exception;
	
	public List<Genearch> queryGenearch(Genearch genearch) throws Exception;
	
	public Genearch getGenearch(String genearchId) throws Exception;
	
}
