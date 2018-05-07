package com.company.tax.persistence;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.logging.Logger;


@Service
public class PersistenceServiceImpl implements PersistenceService {

    private Logger logger = Logger.getLogger(PersistenceServiceImpl.class.getName());

    @Override
    public BigDecimal getTax(String idTax) {
        // todo: implementare recupero informazione dal DB
        // todo: utilizzare ad esempio mongodb
        return new BigDecimal(10.5);
    }

}
