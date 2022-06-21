package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.dto.CreateItemRequest;
import com.takeout.takeout_system.data.dto.ModifyItemRequest;
import com.takeout.takeout_system.data.models.Item;
import com.takeout.takeout_system.data.models.ProductCatalogue;
import com.takeout.takeout_system.data.models.Store;
import com.takeout.takeout_system.data.repositories.ItemRepository;
import com.takeout.takeout_system.exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageItemCrudServiceImpl implements ManageItemCrudService{
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Boolean createItem(CreateItemRequest createItemRequest) {
        Item item = new Item();
        item.setName(createItemRequest.getName());
        item.setOrderPrice(createItemRequest.getOrderPrice());
        item.setStockNumber(createItemRequest.getStockNumber());
        item.setProductCatalogue(new ProductCatalogue());
        item.setStore(new Store());
        Item savedItem = itemRepository.save(item);
        return savedItem.getId() > 0;
    }

    @Override
    public Item findItem(Long id) {
        return itemRepository.findById(id).orElseThrow(()->new ItemNotFoundException(String.format("item with id %d not found", id)));
    }

    @Override
    public Boolean modifyItem(ModifyItemRequest modifyItemRequest) {
        return null;
    }

    @Override
    public Boolean deleteItem(Long id) {
        return null;
    }
}
