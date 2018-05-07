package com.company.tax.service;

import com.company.tax.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.company.tax.persistence.PersistenceService;

@Service
public class TaxServiceImpl implements TaxService {

    @Autowired
    PersistenceService persistenceService;

    @Override
    public Long getTax(String tax) throws Exception {

        // todo: recuperare il dato dallo strato di persistenza

        Type type = Type.findByShortCode(tax);

        if (type == null) {
            return Type.GENERIC.getTaxRate();
        } else {
            return type.getTaxRate();
        }
    }

}
