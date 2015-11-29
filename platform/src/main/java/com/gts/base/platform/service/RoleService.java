package com.gts.base.platform.service;

import java.util.List;
import com.gts.base.platform.dao.entity.Role;

/**
 * @Description: 角色信息业务处理接口
 * @ClassName: RoleDao
 * @author gaoxiang
 * @date 2015年11月25日 下午11:11:38
 */ 
public interface RoleService {
	
	public int insertRole(Role role) throws Exception;
	
	public int updateRole(Role role) throws Exception;
	
	public List<Role> listPageRole(Role role) throws Exception;
	
	public List<Role> queryRole(Role role) throws Exception;
	
	public Role getRole(String roleId) throws Exception;
	
}
