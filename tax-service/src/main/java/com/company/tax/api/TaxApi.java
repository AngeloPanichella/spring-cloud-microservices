package com.company.tax.api;

import java.security.Principal;
import java.util.logging.Logger;

import com.company.tax.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaxApi implements TaxInterface {

    protected Logger logger = Logger.getLogger(TaxApi.class.getName());

    @Autowired
    private TaxService taxService;

    @RequestMapping(value = "/oauth/tax/{idTax}", method = RequestMethod.GET)
    public Long getTax(@PathVariable("idTax") String idTax, Principal principal) throws Exception{
        return taxService.getTax(idTax);
    }

}
