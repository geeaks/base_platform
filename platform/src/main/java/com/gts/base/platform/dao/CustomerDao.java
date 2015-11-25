package com.gts.base.platform.dao;

import java.util.List;
import com.gts.base.platform.dao.entity.Customer;

/**
 * @Description: 客户信息数据访问接口
 * @ClassName: CustomerDao
 * @author gaoxiang
 * @date 2015年11月25日 下午11:10:23
 */ 
public interface CustomerDao {
	
	public int insertCustomer(Customer customer) throws Exception;
	
	public int updateCustomer(Customer customer) throws Exception;
	
	public List<Customer> listPageCustomer(Customer customer) throws Exception;
	
	public List<Customer> queryCustomer(Customer customer) throws Exception;
	
	public Customer getCustomer(String customerId) throws Exception;
	
}
