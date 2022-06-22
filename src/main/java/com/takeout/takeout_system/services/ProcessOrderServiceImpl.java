package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.dto.EnterItemRequest;
import com.takeout.takeout_system.data.models.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;

@Service
public class ProcessOrderServiceImpl implements ProcessOrderService {
    @Autowired
    private SaleService saleService;

    @Override
    public Boolean makeNewOrder() {
        Sale sale = new Sale();
        Sale currentSale = saleService.getCurrentSale();
        return true;
    }

    @Override
    public Boolean enterItem(EnterItemRequest enterItemRequest) {
        return null;
    }

    @Override
    public BigDecimal endOrder() {
        return null;
    }

    @Override
    public Boolean makeCashPayment(BigDecimal amount) {
        return null;
    }
}
