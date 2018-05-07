package com.company.item.persistence;

import com.company.item.model.Item;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;


@Service
public class PersistenceServiceImpl implements PersistenceService {

    private Logger logger = Logger.getLogger(PersistenceServiceImpl.class.getName());

    @Override
    public Item getItem(String id) throws Exception {
        // todo: implementare recupero item dallo strato di persistenza
        // todo: utilizzare ad esempio mongodb cloud
        return new Item();
    }


}
