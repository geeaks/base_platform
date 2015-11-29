package com.gts.base.platform.service;

import java.util.List;
import com.gts.base.platform.dao.entity.PendingItem;

/**
 * @Description: 待办事项业务处理接口
 * @ClassName: PendingItemsDao
 * @author gaoxiang
 * @date 2015年11月25日 下午11:10:23
 */ 
public interface PendingItemService {
	
	public int insertPendingItem(PendingItem PendingItem) throws Exception;
	
	public int updatePendingItem(PendingItem PendingItem) throws Exception;
	
	public List<PendingItem> listPagePendingItem(PendingItem PendingItem) throws Exception;
	
	public List<PendingItem> queryPendingItem(PendingItem PendingItem) throws Exception;
	
	public PendingItem getPendingItem(String PendingItemId) throws Exception;
	
}
