package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.dto.CreateItemRequest;

public interface ManageItemCrudService {
    Boolean createItem(CreateItemRequest createItemRequest);
}
