package com.company.authentication.api;

import com.company.authentication.security.model.Customer;
import com.company.authentication.security.transfer.JwtUserDto;

import com.company.authentication.service.AuthenticationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.security.Principal;


@RestController
public class AuthenticationApi implements AuthenticationInterface {

    final static Logger logger = Logger.getLogger(AuthenticationApi.class);

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = {"/oauth/token"}, method = RequestMethod.GET)
    public ResponseEntity<?> user(Principal principal, @RequestHeader (value = "Authorization") String authorization) throws Exception {
        return ResponseEntity.ok(authenticationService.refreshToken(principal.getName(), authorization));
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JwtUserDto login(@RequestBody Customer customer) throws Exception {
        return authenticationService.login(customer);
    }
}