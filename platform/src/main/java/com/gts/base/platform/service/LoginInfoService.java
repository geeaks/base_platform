package com.gts.base.platform.service;

import java.util.List;
import java.util.Map;
import com.gts.base.platform.dao.entity.LoginInfo;
import com.gts.base.platform.service.bo.LoginInfoBo;

/**
 * @Description: 用户登录信息业务处理接口
 * @ClassName: LoginInfoService
 * @author gaoxiang
 * @date 2015年11月29日 下午3:31:36
 */ 
public interface LoginInfoService {
	
	/**
	 * @Description: 新增用户登录信息
	 * @param loginInfoBo
	 * @return int 返回类型
	 * @author gaoxiang
	 * @date 2015年11月30日 下午9:26:11
	 */
	public int insertLoginInfo(LoginInfo loginInfoBo);
	
	/**
	 * @Description: 更新用户登录信息
	 * @param loginInfoBo
	 * @return int 返回类型
	 * @author gaoxiang
	 * @date 2015年11月30日 下午9:26:01
	 */
	public int updateLoginInfo(LoginInfo loginInfoBo);
	
	/**
	 * @Description: 分页查询登录信息列表
	 * @param userLoginInfo
	 * @return List<LoginInfoBo> 返回类型
	 * @author gaoxiang
	 * @date 2015年11月30日 下午9:25:51
	 */
	public List<LoginInfoBo> listPageLoginInfo(LoginInfo userLoginInfo);
	
	/**
	 * @Description: 查询登录信息列表
	 * @param userLoginInfo
	 * @return List<LoginInfoBo> 返回类型
	 * @author gaoxiang
	 * @date 2015年11月30日 下午9:25:39
	 */
	public List<LoginInfoBo> queryLoginInfo(LoginInfo userLoginInfo);
	
	/**
	 * @Description: 获取用户登录信息
	 * @param id
	 * @return LoginInfoBo 返回类型
	 * @author gaoxiang
	 * @date 2015年11月30日 下午9:25:26
	 */
	public LoginInfoBo getLoginInfo(String id);
	
	/**
	 * @Description: 通过登录名获取用户登录信息
	 * @param loginId 登录名
	 * @return LoginInfoBo 返回类型
	 * @author gaoxiang
	 * @date 2015年11月30日 下午9:25:08
	 */
	public LoginInfoBo getLoginInfoByLoginId(String loginId);
	
	/**
	 * @Description: 校验登陆密码
	 * @param loginPassword
	 * @param password
	 * @return Map<String,Object> 返回类型
	 * @author gaoxiang
	 * @date 2015年11月30日 下午9:24:56
	 */
	public Map<String,Object> verifyLoginPassword(String loginPassword, String password);
	
	/**
	 * @Description: 记录最后登录状态
	 * @param id
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月30日 下午9:28:11
	 */
	public void recordLastLogin(Integer id);
	
}
