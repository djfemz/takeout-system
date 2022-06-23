package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.dto.CreateItemRequest;
import com.takeout.takeout_system.data.dto.CreateStoreRequest;
import com.takeout.takeout_system.data.dto.EnterItemRequest;
import com.takeout.takeout_system.data.models.Item;
import com.takeout.takeout_system.data.models.Store;
import com.takeout.takeout_system.exceptions.StoreException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProcessOrderServiceImplTest {
    @Autowired
    private ManageStoreCrudService manageStoreCrudService;
    @Autowired
    private ProcessOrderService processOrderService;
    @Autowired
    private ManageItemCrudService manageItemCrudService;
    private CreateStoreRequest storeRequest;
    CreateItemRequest itemRequest;

    @BeforeEach
    void setUp(){
        storeRequest = new CreateStoreRequest();
        storeRequest.setName("test store");
        storeRequest.setAddress("test address");

        itemRequest = new CreateItemRequest();
        itemRequest.setName("test item");
        itemRequest.setPrice(BigDecimal.TEN);

    }
    @Test
    void makeNewOrderTest() {
        boolean createStoreResponse = manageStoreCrudService.createStore(storeRequest);
        assertThat(createStoreResponse).isTrue();
        Store store = manageStoreCrudService.findStore(1L);
        store.setCurrentStore(true);
        manageStoreCrudService.save(store);
        boolean makeOrderResponse = processOrderService.makeNewOrder();
        assertThat(makeOrderResponse).isTrue();
    }

    @Test
    void exceptionIsThrownWhenAnOrderIsMadeWithoutCurrentStore(){
        assertThrows(StoreException.class, ()->processOrderService.makeNewOrder());
    }

    @Test
    void enterItem() {
        boolean createStoreResponse = manageStoreCrudService.createStore(storeRequest);
        assertThat(createStoreResponse).isTrue();
        Store store = manageStoreCrudService.findStore(1L);
        boolean createItemResponse = manageItemCrudService.createItem(itemRequest);
        assertThat(createItemResponse).isTrue();
        Item item = manageItemCrudService.findItem(2L);
        item.setStore(store);
        manageItemCrudService.saveItem(item);
        EnterItemRequest enterItemRequest = new EnterItemRequest();
        enterItemRequest.setId(2L);
        enterItemRequest.setQuantity(2);
        boolean enterItemResponse = processOrderService.enterItem(enterItemRequest);
        assertThat(enterItemResponse).isTrue();
    }

    @Test
    void endOrderTest() {
    }

    @Test
    void  makeCashPayment() {
    }
}