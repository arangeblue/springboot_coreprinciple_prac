package com.coreprinciple.basic.order;

public interface OrderService {
    
    Order createdOrder(Long memberId, String itemName, int itemPrice);

}
