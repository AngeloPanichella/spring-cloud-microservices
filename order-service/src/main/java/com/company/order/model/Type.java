package com.company.order.model;

public enum Type {

    GENERIC("GENERIC"),
    MEDICAL("MEDICAL"),
    FOOD("FOOD"),
    BOOK ("BOOK"),
    IMPORTED("IMPORTED");

    private final String shortCode;

    Type(String code) {
        this.shortCode = code;
    }

    public String getShortCode() {
        return shortCode;
    }
}
