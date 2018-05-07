package com.company.authentication.api;

import com.company.authentication.security.model.Customer;
import com.company.authentication.security.transfer.JwtUserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

public interface AuthenticationInterface {

    @RequestMapping(value = {"/oauth/token"}, method = RequestMethod.GET)
    ResponseEntity<?> user(Principal principal, @RequestHeader (value = "Authorization") String authorization) throws Exception;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    JwtUserDto login(@RequestBody Customer customer) throws Exception;

}