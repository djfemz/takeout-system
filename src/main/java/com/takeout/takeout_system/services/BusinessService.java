package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.dto.CreateItemRequest;
import com.takeout.takeout_system.data.dto.ModifyItemRequest;
import com.takeout.takeout_system.data.models.Item;
import com.takeout.takeout_system.data.models.Sale;

import java.util.List;
import java.util.Set;

public interface BusinessService {
    Boolean enterStore(Long id);
    Sale getSaleBy(Long id);
    Sale getSaleBy(String name);
    Boolean createItem(CreateItemRequest createItemRequest);
    Item findItem(Long id);
    Item findBy(String name);
    Boolean modifyItem(Long id, ModifyItemRequest modifyItemRequest) ;
    Boolean deleteItem(Long id);
    Item saveItem(Item item);
    List<Item> getAllItems();
    Set<Sale> excursionPublicOrder(Long id);
}
