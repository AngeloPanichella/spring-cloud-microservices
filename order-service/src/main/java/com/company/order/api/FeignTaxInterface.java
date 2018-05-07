package com.company.order.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("tax-service")
public interface FeignTaxInterface {
    @RequestMapping(value = "/oauth/tax/{idTax}", method = RequestMethod.GET)
    Long getTax(@RequestHeader("Authorization") String authorization, @RequestParam(value = "idTax") String idTax) throws Exception;
}