package com.company.order.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;

public class Item implements Serializable {

    String description;
    BigDecimal price;
    BigDecimal itemTotal;
    Long quantity;
    Type type;
    Boolean isImported;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public BigDecimal getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(BigDecimal itemTotal) {
        this.itemTotal = itemTotal;
    }

    public Boolean getImported() {
        return isImported;
    }

    @JsonProperty(value="isImported")
    public void setImported(Boolean imported) {
        isImported = imported;
    }

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", price=" + price +
                ", itemTotal=" + itemTotal +
                ", quantity=" + quantity +
                ", type=" + type +
                ", isImported=" + isImported +
                '}';
    }
}
