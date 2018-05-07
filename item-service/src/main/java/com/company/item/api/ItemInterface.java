package com.company.item.api;

import com.company.item.model.Item;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

public interface ItemInterface {

    @RequestMapping("/oauth/items/{id}")
    Item findById(@PathVariable("id") String id, Principal principal) throws Exception;

}
