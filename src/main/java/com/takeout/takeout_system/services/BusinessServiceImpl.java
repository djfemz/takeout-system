package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.dto.CreateItemRequest;
import com.takeout.takeout_system.data.dto.ModifyItemRequest;
import com.takeout.takeout_system.data.models.Item;
import com.takeout.takeout_system.data.models.Sale;

import java.util.List;
import java.util.Set;

public class BusinessServiceImpl implements BusinessService{
    @Override
    public Boolean enterStore(Long id) {
        return null;
    }

    @Override
    public Sale getSaleBy(Long id) {
        return null;
    }

    @Override
    public Sale getSaleBy(String name) {
        return null;
    }

    @Override
    public Boolean createItem(CreateItemRequest createItemRequest) {
        return null;
    }

    @Override
    public Item findItem(Long id) {
        return null;
    }

    @Override
    public Item findBy(String name) {
        return null;
    }

    @Override
    public Boolean modifyItem(Long id, ModifyItemRequest modifyItemRequest) {
        return null;
    }

    @Override
    public Boolean deleteItem(Long id) {
        return null;
    }

    @Override
    public Item saveItem(Item item) {
        return null;
    }

    @Override
    public List<Item> getAllItems() {
        return null;
    }

    @Override
    public Set<Sale> excursionPublicOrder(Long id) {
        return null;
    }
}
