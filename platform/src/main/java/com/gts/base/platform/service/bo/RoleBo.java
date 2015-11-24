package com.gts.base.platform.service.bo;

import com.gts.base.platform.dao.base.BaseEntity;

/**
 * @Description: 角色信息实体
 * @ClassName: Role
 * @author gaoxiang
 * @date 2015年11月24日 下午11:01:57
 */
public class RoleBo extends BaseEntity {
	
	/**
	 * @Fields roleId : 角色信息 主键
	 */
	private String roleId;
	
	/**
	 * @Fields roleName : 角色名称
	 */
	private String roleName;
	
	/**
	 * @Fields privilege : 角色权限
	 */
	private String privilege;
	
	public String getRoleId() {
		return roleId;
	}
	
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
	public String getRoleName() {
		return roleName;
	}
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public String getPrivilege() {
		return privilege;
	}
	
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	
}
