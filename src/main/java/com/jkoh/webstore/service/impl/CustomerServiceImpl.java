package com.jkoh.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.jkoh.webstore.domain.Customer;
import com.jkoh.webstore.domain.repository.CustomerRepository;
import com.jkoh.webstore.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.getAllCustomers();
	}

	@Override
	public void addCustomer(Customer customer) throws DataAccessException{
		customerRepository.addCustomer(customer);		
	}

}
