package com.coreprinciple.basic.order;

public class Order {
    
    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int discountPrice;


    public Order(Long memberId, String itemName, int itemPrice, int discountPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }

    public int calculatePrice() {

        return itemPrice - discountPrice;

    }
    

    public Long getMemberId() {
        return this.memberId;
    }


    public String getItemName() {
        return this.itemName;
    }


    public int getItemPrice() {
        return this.itemPrice;
    }


    public int getDiscountPrice() {
        return this.discountPrice;
    }


    @Override
    public String toString() {
        return "{" +
            " memberId='" + getMemberId() + "'" +
            ", itemName='" + getItemName() + "'" +
            ", itemPrice='" + getItemPrice() + "'" +
            ", discountPrice='" + getDiscountPrice() + "'" +
            "}";
    }

    
}
