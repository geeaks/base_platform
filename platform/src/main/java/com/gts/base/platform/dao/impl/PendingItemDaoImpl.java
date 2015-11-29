package com.gts.base.platform.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.gts.base.platform.dao.PendingItemDao;
import com.gts.base.platform.dao.base.BaseDao;
import com.gts.base.platform.dao.entity.PendingItem;

@Repository
public class PendingItemDaoImpl extends BaseDao implements PendingItemDao {

	@Override
	public int insertPendingItem(PendingItem pendingItem) throws Exception {
		int row = this.insert("com.gts.base.platform.pendingItem.insertPendingItem", pendingItem);
		return row;
	}

	@Override
	public int updatePendingItem(PendingItem pendingItem) throws Exception {
		int row = this.update("com.gts.base.platform.pendingItem.updatePendingItem", pendingItem);
		return row;
	}

	@Override
	public List<PendingItem> listPagePendingItem(PendingItem pendingItem) throws Exception {
		List<PendingItem> list = this.queryForList("com.gts.base.platform.pendingItem.listPagePendingItem", pendingItem);
		return list;
	}

	@Override
	public List<PendingItem> queryPendingItem(PendingItem pendingItem) throws Exception {
		List<PendingItem> list = this.queryForList("com.gts.base.platform.pendingItem.queryPendingItem", pendingItem);
		return list;
	}

	@Override
	public PendingItem getPendingItem(Integer pendingItemId) throws Exception {
		PendingItem pendingItem = this.getOne("com.gts.base.platform.pendingItem.getPendingItem", pendingItemId);
		return pendingItem;
	}

}
