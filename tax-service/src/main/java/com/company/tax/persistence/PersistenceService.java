package com.company.tax.persistence;

import java.math.BigDecimal;

public interface PersistenceService {

    BigDecimal getTax(String idTax) throws Exception;

}
