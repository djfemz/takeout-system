package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.dto.*;
import com.takeout.takeout_system.data.models.Customer;
import com.takeout.takeout_system.data.models.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService{
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ManageStoreCrudService manageStoreCrudService;
    @Autowired
    private ManageDeliveryService manageDeliveryService;
    @Override
    public FindCustomerResponse getCustomerById(Long id) {
        return customerService.getCustomerById(id);
    }

    @Override
    public boolean createStore(CreateStoreRequest createStoreRequest) {
        return manageStoreCrudService.createStore(createStoreRequest);

    }

    @Override
    public FindStoreResponse findStore(Long id) {
        return manageStoreCrudService.findStore(id);
    }

    @Override
    public boolean modifyStore(ModifyStoreRequest modifyStoreRequest) {
        return manageStoreCrudService.modifyStore(modifyStoreRequest);
    }

    @Override
    public boolean deleteStore(Long id) {
        return manageStoreCrudService.deleteStore(id);
    }

    @Override
    public FindStoreResponse getCurrentStore() {
        return manageStoreCrudService.getCurrentStore();
    }

    @Override
    public List<FindStoreResponse> getAllStores() {
        return manageStoreCrudService.getAllStores();
    }

    @Override
    public Boolean createDelivery(CreateDeliveryRequest createDeliveryRequest) {
        return manageDeliveryService.createDelivery(createDeliveryRequest);
    }
}
