package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.dto.CreateStoreRequest;
import com.takeout.takeout_system.data.models.Store;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ManageStoreCrudServiceImplTest {
    @Autowired
    private ManageStoreCrudService manageStoreCrudService;
    private CreateStoreRequest storeRequest;

    @BeforeEach
    void setUp(){
        storeRequest = new CreateStoreRequest();
        storeRequest.setName("test-store");
        storeRequest.setAddress("test-address");
    }

    @Test
    void createStoreTest(){
        boolean createStoreResponse = manageStoreCrudService.createStore(storeRequest);
        assertThat(createStoreResponse).isTrue();
    }

    @Test
    void modifyStoreTest(){

    }

    @Test
    void findStoreTest(){
        boolean createStoreResponse = manageStoreCrudService.createStore(storeRequest);
        Store foundStore = manageStoreCrudService.findStore(1L);
        assertThat(foundStore).isNotNull();
    }

    @Test
    void deleteStoreTest(){

    }
}