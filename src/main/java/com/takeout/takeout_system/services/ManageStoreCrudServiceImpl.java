package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.dto.CreateStoreRequest;
import com.takeout.takeout_system.data.dto.ModifyStoreRequest;
import com.takeout.takeout_system.data.models.Store;
import org.springframework.stereotype.Service;

@Service
public class ManageStoreCrudServiceImpl implements ManageStoreCrudService {
    @Override
    public Boolean createStore(CreateStoreRequest createStoreRequest) {
        return null;
    }

    @Override
    public Store findStore(Integer id) {
        return null;
    }

    @Override
    public Boolean modifyStore(ModifyStoreRequest modifyStoreRequest) {
        return null;
    }

    @Override
    public Boolean deleteStore(Integer id) {
        return null;
    }
}
