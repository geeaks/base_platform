package com.gts.base.platform.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.gts.base.platform.dao.RoleDao;
import com.gts.base.platform.dao.base.BaseDao;
import com.gts.base.platform.dao.entity.Role;

@Repository
public class RoleDaoImpl extends BaseDao implements RoleDao {

	@Override
	public int insertRole(Role role) throws Exception {
		int row = this.insert("com.gts.base.platform.role.insertRole", role);
		return row;
	}

	@Override
	public int updateRole(Role role) throws Exception {
		int row = this.update("com.gts.base.platform.role.updateRole", role);
		return row;
	}

	@Override
	public List<Role> listPageRole(Role role) throws Exception {
		List<Role> list = this.queryForList("com.gts.base.platform.role.listPageRole", role);
		return list;
	}

	@Override
	public List<Role> queryRole(Role role) throws Exception {
		List<Role> list = this.queryForList("com.gts.base.platform.role.queryRole", role);
		return list;
	}

	@Override
	public Role getRole(String roleId) throws Exception {
		Role role = this.getOne("com.gts.base.platform.role.getRole", roleId);
		return role;
	}

}
