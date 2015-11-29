package com.gts.base.platform.service;

import java.util.List;
import com.gts.base.platform.dao.entity.Manager;

/**
 * @Description: 管理员 业务处理接口
 * @ClassName: ManagerDao
 * @author gaoxiang
 * @date 2015年11月25日 下午11:10:23
 */ 
public interface ManagerService {
	
	public int insertManager(Manager manager) throws Exception;
	
	public int updateManager(Manager manager) throws Exception;
	
	public List<Manager> listPageManager(Manager manager) throws Exception;
	
	public List<Manager> queryManager(Manager manager) throws Exception;
	
	public Manager getManager(String managerId) throws Exception;
	
}
