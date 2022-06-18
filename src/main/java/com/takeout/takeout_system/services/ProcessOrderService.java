package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.dto.EnterItemRequest;

import java.math.BigInteger;

public interface ProcessOrderService {
    Boolean makeNewOrder();
    Boolean enterItem(EnterItemRequest enterItemRequest);
    BigInteger endOrder();
    Boolean makeCashPayment(BigInteger amount);
}
