package com.gts.base.platform.dao;

import java.util.List;
import com.gts.base.platform.dao.entity.Customer;

public interface CustomerDao {
	
	public int insertCustomer(Customer customer) throws Exception;
	
	public int updateCustomer(Customer customer) throws Exception;
	
	public List<Customer> listPageCustomer(Customer customer) throws Exception;
	
	public List<Customer> queryCustomer(Customer customer) throws Exception;
	
	public Customer getCustomer(String customerId) throws Exception;
	
}
