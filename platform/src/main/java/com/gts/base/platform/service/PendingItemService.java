package com.gts.base.platform.service;

import java.util.List;
import java.util.Map;
import com.gts.base.platform.dao.entity.PendingItem;
import com.gts.base.platform.service.bo.PendingItemBo;

/**
 * @Description: 待办事项业务处理接口
 * @ClassName: PendingItemsDao
 * @author gaoxiang
 * @date 2015年11月25日 下午11:10:23
 */ 
public interface PendingItemService {
	
	public int insertPendingItem(PendingItem pendingItem);
	
	public int updatePendingItem(PendingItem pendingItem);
	
	public List<PendingItemBo> listPagePendingItem(PendingItem  pendingItem);
	
	/**
	 * @Description: 获取所有 与登录用户相关的代办事项
	 * @param userId 登录用户ID
	 * @return Map<String,Object> 返回类型
	 * @author gaoxiang
	 * @date 2015年11月29日 下午11:51:17
	 */
	public Map<String,Object> listPagePendingItem(Integer userId);
	
	public List<PendingItemBo> queryPendingItem(PendingItem pendingItem);
	
	public PendingItemBo getPendingItem(Integer pendingItemId);
	
}
