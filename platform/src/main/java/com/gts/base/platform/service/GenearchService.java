package com.gts.base.platform.service;

import java.util.List;
import com.gts.base.platform.dao.entity.Genearch;

/**
 * @Description: 家长信息业务处理接口
 * @ClassName: GenearchDao
 * @author gaoxiang
 * @date 2015年11月25日 下午11:10:44
 */ 
public interface GenearchService {
	
	public int insertGenearch(Genearch genearch) throws Exception;
	
	public int updateGenearch(Genearch genearch) throws Exception;
	
	public List<Genearch> listPageGenearch(Genearch genearch) throws Exception;
	
	public List<Genearch> queryGenearch(Genearch genearch) throws Exception;
	
	public Genearch getGenearch(String genearchId) throws Exception;
	
}
