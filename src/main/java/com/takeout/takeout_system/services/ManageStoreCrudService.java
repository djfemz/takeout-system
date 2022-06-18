package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.dto.CreateStoreRequest;

public interface ManageStoreCrudService {
    Boolean createStore(CreateStoreRequest createStoreRequest);
}
