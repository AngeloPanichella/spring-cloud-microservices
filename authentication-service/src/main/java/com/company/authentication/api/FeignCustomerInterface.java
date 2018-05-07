package com.company.authentication.api;

import com.company.authentication.security.model.Customer;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("customer-service")
public interface FeignCustomerInterface {

    @RequestMapping("/oauth/customer")
    Customer getCustomerByUsernameAndPassword(@RequestHeader("Authorization") String authorization, @RequestHeader("email") String email, @RequestHeader("password") String password) throws Exception;

}

