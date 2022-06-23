package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.dto.EnterItemRequest;
import com.takeout.takeout_system.data.models.Item;
import com.takeout.takeout_system.data.models.OrderLineItem;
import com.takeout.takeout_system.data.models.Sale;
import com.takeout.takeout_system.data.models.Store;
import com.takeout.takeout_system.data.repositories.OrderLineItemRepository;
import com.takeout.takeout_system.exceptions.BusinessLogicException;
import com.takeout.takeout_system.exceptions.ItemNotFoundException;
import com.takeout.takeout_system.exceptions.SaleNotFoundException;
import com.takeout.takeout_system.exceptions.StoreException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;

@Service
@Slf4j
public class ProcessOrderServiceImpl implements ProcessOrderService {
    @Autowired
    private SaleService saleService;
    @Autowired
    private ManageStoreCrudService manageStoreCrudService;
    @Autowired
    private ManageItemCrudService manageItemCrudService;
    @Autowired
    private OrderLineItemRepository orderLineItemRepository;

    @Override
    public Boolean makeNewOrder() {
        Store currentStore = manageStoreCrudService.getCurrentStore();
        if (currentStore==null) throw new StoreException("you need to enter a store to make a new order");
        log.info("current store-->{}", currentStore);
        Sale currentSale = saleService.getCurrentSale();
        log.info("current sale-->{}", currentSale);
        if (currentSale == null) {
            Sale sale = new Sale();
            sale.setStore(currentStore);
            currentStore.getSales().add(sale);
            sale.setComplete(false);
            sale.setReadyToPay(false);
            sale.setCurrentSale(true);
            return saleService.addSale(sale);
        }
        if(currentSale.isComplete()){
            currentSale.setStore(currentStore);
            currentStore.getSales().add(currentSale);
            currentSale.setComplete(false);
            currentSale.setReadyToPay(false);
            return saleService.addSale(currentSale);
        }
        return false;
    }

    @Override
    public boolean enterItem(EnterItemRequest enterItemRequest) {
        Item item = manageItemCrudService.findItem(enterItemRequest.getId());
        Sale currentSale = saleService.getCurrentSale();
        if (currentSale==null) throw new SaleNotFoundException("cannot perform operation," +
                " current sale does not exist");
        if (item.getStockNumber()<1) throw new ItemNotFoundException("item out of stock");
        if (!currentSale.isComplete()){
            OrderLineItem orderLineItem = new OrderLineItem();
            orderLineItem.setCurrentOrderLineItem(true);
            orderLineItem.setSale(currentSale);
            currentSale.getOrderLineItems().add(orderLineItem);
            orderLineItem.setQuantity(enterItemRequest.getQuantity());
            orderLineItem.setItem(item);
            if (!isValidOrderQuantity(item.getStockNumber(), enterItemRequest.getQuantity()))
                throw new BusinessLogicException("order quantity greater than number in stock");
            item.setStockNumber(item.getStockNumber()-enterItemRequest.getQuantity());
            orderLineItem.setSubAmount(getSubAmount(item, enterItemRequest.getQuantity()));
            currentSale.getOrderLineItems().add(orderLineItem);
            saleService.addSale(currentSale);
            return true;
        }
        return false;
    }

    @Override
    public BigDecimal endOrder() {
        return null;
    }

    @Override
    public Boolean makeCashPayment(BigDecimal amount) {
        return null;
    }

    private BigDecimal getSubAmount(Item item, Integer quantity){
        return item.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    private boolean isValidOrderQuantity(int stockNumber, int quantity){
        return stockNumber>quantity;
    }
}
