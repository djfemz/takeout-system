package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.dto.EnterItemRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;

@Service
public class ProcessOrderServiceImpl implements ProcessOrderService {
    @Override
    public Boolean makeNewOrder() {
        return null;
    }

    @Override
    public Boolean enterItem(EnterItemRequest enterItemRequest) {
        return null;
    }

    @Override
    public BigInteger endOrder() {
        return null;
    }

    @Override
    public Boolean makeCashPayment(BigDecimal amount) {
        return null;
    }
}
