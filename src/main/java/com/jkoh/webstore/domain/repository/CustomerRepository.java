package com.jkoh.webstore.domain.repository;

import java.util.List;

import com.jkoh.webstore.domain.Customer;

public interface CustomerRepository {
	List<Customer> getAllCustomers();
}
