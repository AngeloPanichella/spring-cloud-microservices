package com.company.customer.persistence;

import org.springframework.stereotype.Service;
import com.company.customer.model.Customer;
import com.company.customer.model.CustomerType;

import java.util.logging.Logger;


@Service
public class PersistenceServiceImpl implements PersistenceService {

    private Logger logger = Logger.getLogger(PersistenceServiceImpl.class.getName());

    @Override
    public Customer findCustomer(Customer customer) throws Exception {

        // todo: implementare ricerca customer
        // todo: utilizzare ad esempio mongodb cloud

        Customer customerCursor = new Customer();
        customerCursor.setEmail(customer.getEmail());
        customerCursor.setUsername(customer.getUsername());
        customerCursor.setPassword(customer.getPassword());
        customerCursor.setAge(customer.getAge());
        customerCursor.setGender(customer.getGender());
        customerCursor.setCustomerType(CustomerType.INDIVIDUAL);

        return customerCursor;
    }

}
