package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.dto.CreateStoreRequest;
import com.takeout.takeout_system.data.dto.ModifyStoreRequest;
import com.takeout.takeout_system.data.models.Store;
import com.takeout.takeout_system.data.repositories.StoreRepository;
import com.takeout.takeout_system.exceptions.StoreException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ManageStoreCrudServiceImpl implements ManageStoreCrudService {

    @Autowired
    private StoreRepository storeRepository;
    private final ModelMapper mapper = new ModelMapper();


    @Override
    public boolean createStore(CreateStoreRequest createStoreRequest) {
        Store store = mapper.map(createStoreRequest, Store.class);
        store.setOpened(true);
        Store savedStore = storeRepository.save(store);
        if (savedStore!=null) return true;
        return false;
    }

    @Override
    public Store findStore(Long id) {
        return storeRepository.findById(id).orElseThrow(()->new StoreException(String.format("store with id %d not found", id)));
    }

    @Override
    public boolean modifyStore(ModifyStoreRequest modifyStoreRequest) {
        return false;
    }

    @Override
    public boolean deleteStore(Long id) {
        return false;
    }
}
