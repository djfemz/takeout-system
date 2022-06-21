package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.dto.CreateItemRequest;
import com.takeout.takeout_system.data.dto.ModifyItemRequest;
import com.takeout.takeout_system.data.models.Item;

public interface ManageItemCrudService {
    Boolean createItem(CreateItemRequest createItemRequest);
    Item findItem(Long id);
    Boolean modifyItem(ModifyItemRequest modifyItemRequest);
    Boolean deleteItem(Long id);
}
