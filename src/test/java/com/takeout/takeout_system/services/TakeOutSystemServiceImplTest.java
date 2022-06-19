package com.takeout.takeout_system.services;


import com.takeout.takeout_system.data.dto.CreateDeliveryRequest;
import com.takeout.takeout_system.data.models.Delivery;
import com.takeout.takeout_system.data.models.Sale;
import com.takeout.takeout_system.data.models.Store;
import com.takeout.takeout_system.exceptions.SaleNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class TakeOutSystemServiceImplTest {
    @Autowired
    private TakeOutSystemService takeOutSystemService;
    @Autowired
    private SaleService saleService;
    @Autowired
    private ManageDeliveryService manageDeliveryService;

    private Sale sale;

    private CreateDeliveryRequest deliveryRequest;


    @BeforeEach
    void setUp(){
        sale = new Sale();
        sale.setName("test sale");
        sale.setStore(new Store("test store", "test address"));
        deliveryRequest=new CreateDeliveryRequest();
        deliveryRequest.setName("test deliveryy");
    }

    @Test
    void acceptOrderTest() throws SaleNotFoundException {
        saleService.addSale(sale);
        Boolean acceptOrderResponse = takeOutSystemService.acceptOrder("test sale");
       assertThat(acceptOrderResponse).isTrue();
    }

    @Test
    void  terminateOrderTest() throws SaleNotFoundException {
        Boolean terminateOrderResponse = takeOutSystemService.terminateOrder("test sale");
        assertThat(terminateOrderResponse).isTrue();
    }

    @Test
    void excursionPublicOrderTest() {
        manageDeliveryService.createDelivery(deliveryRequest);
        Delivery delivery = manageDeliveryService.findByName(deliveryRequest.getName());
        log.info("delivery-id->{}", delivery.getId());
        Set<Sale> deliverySet = takeOutSystemService.excursionPublicOrder(delivery.getId().toString());
        assertThat(deliverySet).containsExactly(delivery.getSale().toArray(new Sale[0]));
    }

    @Test
    void enterStoreTest() {

    }

    @Test
    void searchTest() {

    }
}