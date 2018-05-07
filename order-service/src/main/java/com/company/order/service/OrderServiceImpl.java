package com.company.order.service;

import com.company.order.api.FeignItemInterface;
import com.company.order.api.FeignTaxInterface;
import com.company.order.model.Item;
import com.company.order.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.company.order.model.Order;
import com.company.order.persistence.PersistenceService;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

@Service
public class OrderServiceImpl implements OrderService {

    private Logger logger = Logger.getLogger(OrderServiceImpl.class.getName());

    @Autowired
    private FeignTaxInterface feignTaxInterface;

    @Autowired
    private FeignItemInterface feignItemInterface;

    @Autowired
    PersistenceService persistenceService;

    @Override
    public Order createOrder(Order order, String feignAuth) throws Exception {

        BigDecimal totalOrder = new BigDecimal(0);
        BigDecimal totalTax = new BigDecimal(0);

        List<Item> itemList = order.getItemList();

        for (Item item : itemList) {
            Item checkExistItem = feignItemInterface.findById(feignAuth, item.getDescription());

            Long taxRate = feignTaxInterface.getTax(feignAuth, item.getType().getShortCode());
            Long importedTax = 0L;
            if (item.getImported()) {
                importedTax = feignTaxInterface.getTax(feignAuth, Type.IMPORTED.getShortCode());
            }

            Long totalTaxRate = taxRate + importedTax;
            BigDecimal calculatedTax = new BigDecimal(roundTo05Decimal(item.getPrice().multiply(new BigDecimal(totalTaxRate)).divide(new BigDecimal(100L))));

            BigDecimal totalItem = item.getPrice().add(calculatedTax).setScale(2,BigDecimal.ROUND_HALF_EVEN);

            totalTax = totalTax.add(calculatedTax).setScale(2, BigDecimal.ROUND_HALF_EVEN);
            totalOrder = totalOrder.add(totalItem).setScale(2, BigDecimal.ROUND_HALF_EVEN);

            item.setItemTotal(totalItem);

        }

        order.setTotalOrder(totalOrder);
        order.setTotalTax(totalTax);

        return persistenceService.createOrder(order);

    }

    public static Double roundTo05Decimal(BigDecimal num) {
        return (Math.ceil(num.doubleValue() * 20) / 20.0);
    }

}
