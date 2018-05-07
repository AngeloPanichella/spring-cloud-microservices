package com.company.order.api;

import java.util.logging.Logger;

import com.company.order.model.Order;
import com.company.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderApi implements OrderInterface {

    protected Logger logger = Logger.getLogger(OrderApi.class.getName());

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/oauth/order", method = RequestMethod.POST)
    public Order createOrder(@RequestBody Order order, @RequestHeader(value="Authorization") String feignAuth) throws Exception {
        return orderService.createOrder(order, feignAuth);
    }

}
