package com.gts.base.platform.service;

import java.util.List;
import com.gts.base.platform.dao.entity.LoginLog;
import com.gts.base.platform.service.bo.LoginLogBo;

/**
 * @Description: 登录日志信息业务处理接口
 * @ClassName: LoginLogService
 * @author gaoxiang
 * @date 2015年11月29日 下午3:31:26
 */ 
public interface LoginLogService {

	public int insertLoginLog(LoginLog loginLog);
	
	public List<LoginLogBo> listPageLoginLog(LoginLog loginLog);
	
	public List<LoginLogBo> queryLoginLog(LoginLog loginLog);
	
	public LoginLogBo getLoginLog(String loginLogId);

	/**
	 * @Description: 记录登录日志
	 * @param userId
	 * @param clientIP
	 * @param clinetPlace
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月28日 下午12:15:26
	 */
	public void recordLoginLog(Integer userId,String loginId, String clientIP, String clinetPlace);
}
