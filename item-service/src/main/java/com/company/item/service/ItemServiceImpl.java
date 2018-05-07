package com.company.item.service;

import com.company.item.exceptions.ItemNotFoundException;
import com.company.item.model.Item;
import com.company.item.persistence.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    PersistenceService persistenceService;

    @Override
    public Item getItem(String id) throws Exception {
        Item item = persistenceService.getItem(id);
        if (item != null){
            return item;
        } else {
            throw new ItemNotFoundException("item not found");
        }
    }

}
