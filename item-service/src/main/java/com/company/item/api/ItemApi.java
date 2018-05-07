package com.company.item.api;

import java.security.Principal;
import java.util.logging.Logger;

import com.company.item.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.company.item.service.ItemService;

@RestController
public class ItemApi implements ItemInterface {

    protected Logger logger = Logger.getLogger(ItemApi.class.getName());

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/oauth/items/{id}", method = RequestMethod.GET)
    public Item findById(@PathVariable("id") String id, Principal principal) throws Exception{
        return itemService.getItem(id);
    }

}
