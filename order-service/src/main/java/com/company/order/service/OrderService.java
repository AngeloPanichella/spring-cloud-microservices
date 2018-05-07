package com.company.order.service;

import com.company.order.model.Order;

public interface OrderService {

    Order createOrder(Order order, String feignAuth) throws Exception;

}
