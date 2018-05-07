package com.company.customer.service;

import com.company.customer.exceptions.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.company.customer.model.Customer;
import com.company.customer.persistence.PersistenceService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    PersistenceService persistenceService;

    @Override
    public Customer getCustomer(Customer customer) throws Exception {
        Customer customerFind = persistenceService.findCustomer(customer);
        if (customerFind == null){
            throw new CustomerNotFoundException("CUSTOMER NOT FOUND");
        }
        return customerFind;
    }
}
