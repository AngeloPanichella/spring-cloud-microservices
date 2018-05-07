package com.company.order.api;

import com.company.order.model.Item;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("item-service")
public interface FeignItemInterface {

    @RequestMapping(value = "/oauth/items/{id}", method = RequestMethod.GET)
    Item findById(@RequestHeader("Authorization") String authorization, @PathVariable("id") String number) throws Exception;
}
