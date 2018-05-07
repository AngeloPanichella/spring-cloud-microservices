package com.company.order.persistence;

import com.company.order.model.Order;

public interface PersistenceService {

    Order createOrder(Order order) throws Exception;

}
