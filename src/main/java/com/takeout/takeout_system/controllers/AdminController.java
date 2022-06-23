package com.takeout.takeout_system.controllers;

import com.takeout.takeout_system.data.dto.*;
import com.takeout.takeout_system.data.models.Customer;
import com.takeout.takeout_system.data.models.Store;
import com.takeout.takeout_system.services.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    @Autowired
    private AdministratorService administratorService;

    @GetMapping("/customer/{id}")
    public FindCustomerResponse getCustomerById(@PathVariable Long id){
        return administratorService.getCustomerById(id);
    }

    @PostMapping("/store/create")
    public boolean createStore(@RequestBody CreateStoreRequest createStoreRequest){
       return administratorService.createStore(createStoreRequest);
    }

    @GetMapping("/store/{id}")
    public FindStoreResponse findStore(@PathVariable Long id){
        return administratorService.findStore(id);
    }

    @PostMapping("/store/modify")
    public boolean modifyStore(ModifyStoreRequest modifyStoreRequest){
        return administratorService.modifyStore(modifyStoreRequest);
    }

    @DeleteMapping("/store/{id}")
    public boolean deleteStore(@PathVariable Long id){
        return administratorService.deleteStore(id);
    }

    @GetMapping("/store/current")
    public FindStoreResponse getCurrentStore(){
        return administratorService.getCurrentStore();
    }
    @GetMapping("/store/all")
    public List<FindStoreResponse> getAllStores(){
        return administratorService.getAllStores();
    }

    @PostMapping("/delivery/create")
    public boolean createDelivery(@RequestBody CreateDeliveryRequest createDeliveryRequest){
        return administratorService.createDelivery(createDeliveryRequest);
    }
}
