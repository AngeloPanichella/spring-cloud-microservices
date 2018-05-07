package com.company.customer.persistence;

import com.company.customer.model.Customer;

public interface PersistenceService {

    Customer findCustomer(Customer customer) throws Exception;
}
