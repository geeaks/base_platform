package com.gts.base.platform.service.impl;

import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.gts.base.platform.dao.PendingItemDao;
import com.gts.base.platform.dao.entity.PendingItem;
import com.gts.base.platform.dao.plugin.util.Page;
import com.gts.base.platform.service.PendingItemService;
import com.gts.base.platform.service.base.BaseService;
import com.gts.base.platform.service.bo.PendingItemBo;

@Service
public class PendingItemImpl extends BaseService implements PendingItemService {
	
	public static Logger LOGGER = Logger.getLogger(PendingItemImpl.class);
	
	@Autowired
	private PendingItemDao pendingItemDao;
	
	@Override
	public int insertPendingItem(PendingItem pendingItem) {
		int affectRow = 0;
		try {
			affectRow = pendingItemDao.insertPendingItem(pendingItem);
		} catch (Exception e) {
			LOGGER.error("保存用户信息系统异常", e);
		}
		return affectRow;
	}

	@Override
	public int updatePendingItem(PendingItem pendingItem) {
		int affectRow = 0;
		try {
			affectRow = pendingItemDao.insertPendingItem(pendingItem);
		} catch (Exception e) {
			LOGGER.error("修改用户信息系统异常", e);
		}
		return affectRow;
	}

	@Override
	public List<PendingItemBo> listPagePendingItem(PendingItem pendingItem) {
		List<PendingItemBo> listBo = Lists.newArrayList();
		try {
			for (PendingItem pendingItemInfo : pendingItemDao.listPagePendingItem(pendingItem)) {
				PendingItemBo pendingItemBo = new PendingItemBo();
				BeanUtils.copyProperties(pendingItemBo,pendingItemInfo);
				listBo.add(pendingItemBo);
			}
		} catch (Exception e) {
			LOGGER.error("分页查询用户信息系统异常", e);
		}
		return listBo;
	}
	
	@Override
	public Map<String,Object> listPagePendingItem(Integer userId) {
		Map<String,Object> map = Maps.newHashMap();
		PendingItem pendingItem = new PendingItem();
		pendingItem.setApplicantUserId(userId);
		pendingItem.setHandlerUserId(userId);
		Page page = new Page();
		pendingItem.setPage(page);
		List<PendingItemBo> list= this.listPagePendingItem(pendingItem);
		map.put("list", list);
		map.put("page", pendingItem.getPage());
		return map;
	}

	@Override
	public List<PendingItemBo> queryPendingItem(PendingItem pendingItem) {
		List<PendingItemBo> listBo = Lists.newArrayList();
		try {
			for (PendingItem pendingItemInfo : pendingItemDao.listPagePendingItem(pendingItem)) {
				PendingItemBo pendingItemBo = new PendingItemBo();
				BeanUtils.copyProperties(pendingItemBo,pendingItemInfo);
				listBo.add(pendingItemBo);
			}
		} catch (Exception e) {
			LOGGER.error("查询用户信息系统异常", e);
		}
		return listBo;
	}

	@Override
	public PendingItemBo getPendingItem(Integer pendingItemId) {
		try {
			PendingItem pendingItem = pendingItemDao.getPendingItem(pendingItemId);
			if(pendingItem == null){
				return null;
			}
			PendingItemBo pendingItemBo = new PendingItemBo();
			BeanUtils.copyProperties(pendingItemBo, pendingItem);
			return pendingItemBo;
		} catch (Exception e) {
			LOGGER.error("获取用户信息系统异常", e);
		}
		return null;
	}

}
