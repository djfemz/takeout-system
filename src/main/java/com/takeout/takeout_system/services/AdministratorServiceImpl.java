package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.dto.CreateDeliveryRequest;
import com.takeout.takeout_system.data.dto.CreateStoreRequest;
import com.takeout.takeout_system.data.dto.ModifyStoreRequest;
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
    public Customer getCustomerById(Long id) {
        return customerService.getCustomerById(id);
    }

    @Override
    public boolean createStore(CreateStoreRequest createStoreRequest) {
        return manageStoreCrudService.createStore(createStoreRequest);

    }

    @Override
    public Store findStore(Long id) {
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
    public Store getCurrentStore() {
        return manageStoreCrudService.getCurrentStore();
    }

    @Override
    public List<Store> getAllStores() {
        return manageStoreCrudService.getAllStores();
    }

    @Override
    public Boolean createDelivery(CreateDeliveryRequest createDeliveryRequest) {
        return manageDeliveryService.createDelivery(createDeliveryRequest);
    }
}
