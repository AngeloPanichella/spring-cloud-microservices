package com.company.authentication.service;

import com.company.authentication.security.model.Customer;
import com.company.authentication.security.transfer.JwtUserDto;

public interface AuthenticationService {

    JwtUserDto login(Customer customer) throws Exception;

    JwtUserDto checkToken(String token) throws Exception;

    JwtUserDto refreshToken(String email, String refreshToken) throws Exception;
}
