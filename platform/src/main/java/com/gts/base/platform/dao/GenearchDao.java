package com.gts.base.platform.dao;

import java.util.List;
import com.gts.base.platform.dao.entity.Genearch;

/**
 * @Description: 家长信息数据访问接口
 * @ClassName: GenearchDao
 * @author gaoxiang
 * @date 2015年11月25日 下午11:10:44
 */ 
public interface GenearchDao {
	
	public int insertGenearch(Genearch genearch) throws Exception;
	
	public int updateGenearch(Genearch genearch) throws Exception;
	
	public List<Genearch> listPageGenearch(Genearch genearch) throws Exception;
	
	public List<Genearch> queryGenearch(Genearch genearch) throws Exception;
	
	public Genearch getGenearch(String genearchId) throws Exception;
	
}
