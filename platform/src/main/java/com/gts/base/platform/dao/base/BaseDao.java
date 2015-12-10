package com.gts.base.platform.dao.base;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * @Description: 基础数据访问功能
 * @ClassName: BaseDao
 * @author gaoxiang
 * @date 2015年11月25日 上午12:04:24
 */ 
public class BaseDao extends SqlSessionDaoSupport {
	
	@Resource(name = "mysql_sqlSessionTemplate")
	public void setSqlSessionTemplate(SqlSessionTemplate mysql_sharedTransactionTemplate) {
		super.setSqlSessionTemplate(mysql_sharedTransactionTemplate);
	}
	
	/**
	 * Description: 新增一条记录
	 * @param statementName SQL语句的ID
	 * @param object 参数
	 */
	public int insert(String statementName, Object object) {
		return getSqlSession().insert(statementName, object);
	}

	/**
	 * Description: 更新一条记录
	 * @param statementName SQL语句的ID
	 * @param object 参数
	 */
	public int update(String statementName, Object object) {
		return getSqlSession().update(statementName, object);
	}

	/**
	 * Description: 删除一条记录
	 * @param statementName SQL语句的ID
	 * @param object 参数
	 */
	public void delete(String statementName, Object object) {
		getSqlSession().delete(statementName, object);
	}

	/**
	 * Description: 获取一条记录(一般根据逐渐获取)
	 * @param statementName SQL语句ID
	 * @param object 参数
	 * @return 符合条件的一条记录
	 */
	public <T> T getOne(String statementName, Object object) {
		return getSqlSession().selectOne(statementName, object);
	}

	/**
	 * 
	 * Description: 查询所有
	 * @param statementName SQL语句的ID
	 * @return
	 */
	public <T> List<T> queryForList(String statementName) {
		return getSqlSession().selectList(statementName);
	}

	/**
	 * Description: 根据条件查询
	 * @param statementName SQL语句的ID
	 * @param paramObj 查询条件
	 * @return
	 */
	public <T> List<T> queryForList(String statementName, Object paramObj) {
		return getSqlSession().selectList(statementName, paramObj);
	}
	
}
