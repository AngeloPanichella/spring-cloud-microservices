package com.company.order.api;

import com.company.order.model.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public interface OrderInterface {

    @RequestMapping(value = "/oauth/order", method = RequestMethod.POST)
    Order createOrder(Order order, String feignAuth) throws Exception;

}