package com.company.customer.api;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.company.customer.model.Customer;
import com.company.customer.service.CustomerService;

@RestController
public class CustomerApi implements CustomerInterface {

    protected Logger logger = Logger.getLogger(CustomerApi.class.getName());

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/oauth/customer", method = RequestMethod.GET)
    public Customer getCustomerByUsernameAndPassword(String email, String password) throws Exception {
        return customerService.getCustomer(new Customer(email, password));
    }

}
