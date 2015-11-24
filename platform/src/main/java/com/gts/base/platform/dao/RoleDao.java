package com.gts.base.platform.dao;

import java.util.List;
import com.gts.base.platform.dao.entity.Role;

public interface RoleDao {
	
	public int insertRole(Role role) throws Exception;
	
	public int updateRole(Role role) throws Exception;
	
	public List<Role> listPageRole(Role role) throws Exception;
	
	public List<Role> queryRole(Role role) throws Exception;
	
	public Role getRole(String roleId) throws Exception;
	
}
