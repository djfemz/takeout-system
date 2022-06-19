package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.models.Delivery;
import com.takeout.takeout_system.data.models.Item;
import com.takeout.takeout_system.data.models.Sale;
import com.takeout.takeout_system.exceptions.SaleNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Getter
@Setter
@Service
public class TakeOutSystemServiceImpl implements TakeOutSystemService {
    @Autowired
    private SaleService saleService;

    private Delivery currentDelivery;


    @Override
    public Boolean acceptOrder(String name) throws SaleNotFoundException {
        Sale sale = saleService.getSaleBy(name);
        if (sale==null) throw new SaleNotFoundException("no such sale found");
        currentDelivery=sale.getDelivery();
        sale.setIsAccept(true);
        sale.setDelivery(currentDelivery);
        return saleService.addSale(sale);
    }

    @Override
    public Boolean terminateOrder(String name) {
        return null;
    }

    @Override
    public Set<Sale> excursionPublicOrder(String id) {
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
