package com.company.order.api;


import com.company.order.security.model.JwtUserDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("authentication-service")
public interface FeignAuthenticationInterface {
    @RequestMapping(value = "/oauth/token", method = RequestMethod.GET)
    JwtUserDto user(@RequestHeader("Authorization") String authorization) throws Exception;
}