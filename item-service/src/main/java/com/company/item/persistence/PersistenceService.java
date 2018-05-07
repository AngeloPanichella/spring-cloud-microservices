package com.company.item.persistence;

import com.company.item.model.Item;

public interface PersistenceService {

    Item getItem(String id) throws Exception;

}
