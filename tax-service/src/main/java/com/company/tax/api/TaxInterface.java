package com.company.tax.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;


public interface TaxInterface {

    @RequestMapping("/oauth/tax/{idTax}")
    Long getTax(@PathVariable("idTax") String number, Principal principal) throws Exception;

}