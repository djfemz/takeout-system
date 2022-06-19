package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.models.Delivery;
import com.takeout.takeout_system.data.models.Item;
import com.takeout.takeout_system.data.models.Sale;
import com.takeout.takeout_system.exceptions.SaleNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Getter
@Setter
@Service
@Slf4j
public class TakeOutSystemServiceImpl implements TakeOutSystemService {
    @Autowired
    private SaleService saleService;
    private ManageDeliveryService manageDeliveryService;
    private Delivery currentDelivery;


    @Override
    public Boolean acceptOrder(String name) throws SaleNotFoundException {
        Sale sale = saleService.getSaleBy(name);
        if (sale==null) throw new SaleNotFoundException("no such sale found");
        currentDelivery=sale.getDelivery();
        sale.setAccept(true);
        sale.setDelivery(currentDelivery);
        return saleService.addSale(sale);
    }

    @Override
    public Boolean terminateOrder(String name) throws SaleNotFoundException {
        Sale foundSale = saleService.getSaleBy(name);
        if (foundSale==null) throw new SaleNotFoundException("no such sale found");
        currentDelivery = foundSale.getDelivery();
        if (foundSale.isAccept()) foundSale.setComplete(true);
        return saleService.addSale(foundSale);
    }

    @Override
    public Set<Sale> excursionPublicOrder(String id) {
        Delivery delivery = manageDeliveryService.getDeliveryBy(id);
        if (delivery!=null) return delivery.getSale();
        return null;
    }

    @Override
    public Boolean enterStore(Integer id) {
        return null;
    }

    @Override
    public Item search(String name) {
        return null;
    }
}
