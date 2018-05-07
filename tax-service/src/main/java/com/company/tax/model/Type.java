package com.company.tax.model;

public enum Type {

    MEDICAL("MEDICAL", 0L),
    FOOD("FOOD", 0L),
    BOOK ("BOOK", 0L),
    GENERIC("GENERIC", 10L),
    IMPORTED("IMPORTED", 5L);

    private final String shortCode;
    private Long taxRate;

    Type(String shortCode, Long taxRate) {
        this.shortCode = shortCode;
        this.taxRate = taxRate;
    }

    public String getShortCode() {
        return shortCode;
    }

    public Long getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Long taxRate) {
        this.taxRate = taxRate;
    }

    public static Type findByShortCode(String code){
        for(Type v : values()){
            if( v.shortCode.equals(code)){
                return v;
            }
        }
        return null;
    }
}
