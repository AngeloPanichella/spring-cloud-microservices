package com.company.customer.api;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.company.customer.model.Customer;


public interface CustomerInterface {

    @RequestMapping(value = "/oauth/customer", method = RequestMethod.GET)
    Customer getCustomerByUsernameAndPassword(@RequestHeader("email") String email, @RequestHeader("password") String password) throws Exception;

}