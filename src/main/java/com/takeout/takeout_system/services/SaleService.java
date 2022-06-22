package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.models.Sale;

public interface SaleService {
    Boolean addSale(Sale sale);
    Sale getSaleBy(Long id);
    Sale getSaleBy(String name);
    Sale getCurrentSale();
}
