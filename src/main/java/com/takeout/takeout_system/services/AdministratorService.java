package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.dto.CreateDeliveryRequest;
import com.takeout.takeout_system.data.dto.CreateStoreRequest;
import com.takeout.takeout_system.data.dto.ModifyStoreRequest;
import com.takeout.takeout_system.data.models.Customer;
import com.takeout.takeout_system.data.models.Delivery;
import com.takeout.takeout_system.data.models.Store;

import java.util.List;

public interface AdministratorService {
    Customer getCustomerById(Long id);
    boolean createStore(CreateStoreRequest createStoreRequest);
    Store findStore(Long id);
    boolean modifyStore(ModifyStoreRequest modifyStoreRequest);
    boolean deleteStore(Long id);
    Store getCurrentStore();
    List<Store> getAllStores();
    Boolean createDelivery(CreateDeliveryRequest createDeliveryRequest);
}
