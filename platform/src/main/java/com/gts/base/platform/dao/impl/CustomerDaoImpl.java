package com.gts.base.platform.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.gts.base.platform.dao.CustomerDao;
import com.gts.base.platform.dao.base.BaseDao;
import com.gts.base.platform.dao.entity.Customer;

@Repository
public class CustomerDaoImpl extends BaseDao implements CustomerDao {

	@Override
	public int insertCustomer(Customer customer) throws Exception {
		int row = this.insert("com.gts.base.platform.customer.insertCustomer", customer);
		return row;
	}

	@Override
	public int updateCustomer(Customer customer) throws Exception {
		int row = this.update("com.gts.base.platform.customer.updateCustomer", customer);
		return row;
	}

	@Override
	public List<Customer> listPageCustomer(Customer customer) throws Exception {
		List<Customer> list = this.queryForList("com.gts.base.platform.customer.listPageCustomer", customer);
		return list;
	}

	@Override
	public List<Customer> queryCustomer(Customer customer) throws Exception {
		List<Customer> list = this.queryForList("com.gts.base.platform.customer.queryCustomer", customer);
		return list;
	}

	@Override
	public Customer getCustomer(String customerId) throws Exception {
		Customer customer = this.getOne("com.gts.base.platform.customer.getCustomer", customerId);
		return customer;
	}

}
