package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.dto.CreateItemRequest;
import com.takeout.takeout_system.data.dto.ModifyItemRequest;
import com.takeout.takeout_system.data.models.Item;
import org.springframework.stereotype.Service;

@Service
public class ManageItemCrudServiceImpl implements ManageItemCrudService{
    @Override
    public Boolean createItem(CreateItemRequest createItemRequest) {
        return null;
    }

    @Override
    public Item findItem(Integer id) {
        return null;
    }

    @Override
    public Boolean modifyItem(ModifyItemRequest modifyItemRequest) {
        return null;
    }

    @Override
    public Boolean deleteItem(Integer id) {
        return null;
    }
}
