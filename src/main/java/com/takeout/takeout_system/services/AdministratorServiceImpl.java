package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.dto.CreateDeliveryRequest;
import com.takeout.takeout_system.data.dto.CreateStoreRequest;
import com.takeout.takeout_system.data.dto.ModifyStoreRequest;
import com.takeout.takeout_system.data.models.Customer;
import com.takeout.takeout_system.data.models.Store;

import java.util.List;

public class AdministratorServiceImpl implements AdministratorService{
    @Override
    public Customer getCustomerById(Long id) {
        return null;
    }

    @Override
    public boolean createStore(CreateStoreRequest createStoreRequest) {
        return false;
    }

    @Override
    public Store findStore(Long id) {
        return null;
    }

    @Override
    public boolean modifyStore(ModifyStoreRequest modifyStoreRequest) {
        return false;
    }

    @Override
    public boolean deleteStore(Long id) {
        return false;
    }

    @Override
    public Store getCurrentStore() {
        return null;
    }

    @Override
    public List<Store> getAllStores() {
        return null;
    }

    @Override
    public Boolean createDelivery(CreateDeliveryRequest createDeliveryRequest) {
        return null;
    }
}
