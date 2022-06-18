package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.dto.CreateStoreRequest;
import com.takeout.takeout_system.data.dto.ModifyStoreRequest;
import com.takeout.takeout_system.data.models.Store;

public interface ManageStoreCrudService {
    Boolean createStore(CreateStoreRequest createStoreRequest);
    Store findStore(Integer id);
    Boolean modifyStore(ModifyStoreRequest modifyStoreRequest);
    Boolean deleteStore(Integer id);
}
