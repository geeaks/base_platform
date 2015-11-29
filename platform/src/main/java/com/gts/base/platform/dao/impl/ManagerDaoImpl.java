package com.gts.base.platform.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.gts.base.platform.dao.ManagerDao;
import com.gts.base.platform.dao.base.BaseDao;
import com.gts.base.platform.dao.entity.Manager;

@Repository
public class ManagerDaoImpl extends BaseDao implements ManagerDao {

	@Override
	public int insertManager(Manager manager) throws Exception {
		int row = this.insert("com.gts.base.platform.manager.insertManager", manager);
		return row;
	}

	@Override
	public int updateManager(Manager manager) throws Exception {
		int row = this.update("com.gts.base.platform.manager.updateManager", manager);
		return row;
	}

	@Override
	public List<Manager> listPageManager(Manager manager) throws Exception {
		List<Manager> list = this.queryForList("com.gts.base.platform.manager.listPageManager", manager);
		return list;
	}

	@Override
	public List<Manager> queryManager(Manager manager) throws Exception {
		List<Manager> list = this.queryForList("com.gts.base.platform.manager.queryManager", manager);
		return list;
	}

	@Override
	public Manager getManager(String managerId) throws Exception {
		Manager manager = this.getOne("com.gts.base.platform.manager.getManager", managerId);
		return manager;
	}

}
