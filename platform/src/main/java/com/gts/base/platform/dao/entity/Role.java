package com.gts.base.platform.dao.entity;

import com.gts.base.platform.dao.base.BaseEntity;

/**
 * @Description: 角色信息实体
 * @ClassName: Role
 * @author gaoxiang
 * @date 2015年11月24日 下午11:01:57
 */
public class Role extends BaseEntity {
	
	/**
	 * @Fields roleId : 角色信息 主键
	 */
	private Integer roleId;
	
	/**
	 * @Fields roleName : 角色名称
	 */
	private String roleName;
	
	/**
	 * @Fields privilege : 角色权限
	 */
	private String privilege;
	
	public Integer getRoleId() {
		return roleId;
	}
	
	public void setRoleId(Integer roleId) {
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
