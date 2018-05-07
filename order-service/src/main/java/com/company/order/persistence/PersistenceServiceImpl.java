package com.company.order.persistence;

import com.company.order.model.Order;
import org.springframework.stereotype.Service;

@Service
public class PersistenceServiceImpl implements PersistenceService {

    @Override
    public Order createOrder(Order order) throws Exception {

        // todo: implementare logica di salvataggio sullo strato di persistenza
        // todo: utilizzare ad esempio mongosb cloud

        return order;
    }

}
