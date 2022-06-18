package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.models.Item;
import com.takeout.takeout_system.data.models.Sale;

import java.util.Set;

public interface TakeOutSystemService {
    Boolean acceptOrder(String name);
    Boolean terminateOrder(String name);
    Set<Sale> excursionPublicOrder(String id);
    Boolean enterStore(Integer id);
    Item search(String name);
}
