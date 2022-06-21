package com.takeout.takeout_system.services;


import com.takeout.takeout_system.data.dto.CreateDeliveryRequest;
import com.takeout.takeout_system.data.dto.CreateStoreRequest;
import com.takeout.takeout_system.data.models.Delivery;
import com.takeout.takeout_system.data.models.Sale;
import com.takeout.takeout_system.data.models.Store;
import com.takeout.takeout_system.data.repositories.DeliveryRepository;
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
    private TakeOutSystemServiceImpl takeOutSystemService;
    @Autowired
    private SaleService saleService;
    @Autowired
    private ManageDeliveryService manageDeliveryService;
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private ManageStoreCrudService manageStoreCrudService;

    private Sale sale;

    private CreateDeliveryRequest deliveryRequest;

    private CreateStoreRequest createStoreRequest;

    @BeforeEach
    void setUp(){
        deliveryRepository.deleteAll();
        sale = new Sale();
        sale.setName("test sale");
        sale.setStore(new Store("test store", "test address"));
        saleService.addSale(sale);

        deliveryRequest=new CreateDeliveryRequest();
        deliveryRequest.setName("test deliveryy");

        createStoreRequest=new CreateStoreRequest();
        createStoreRequest.setAddress("test address");
        createStoreRequest.setName("test store");

    }

    @Test
    void acceptOrderTest() throws SaleNotFoundException {
        Boolean acceptOrderResponse = takeOutSystemService.acceptOrder("test sale");
        assertThat(acceptOrderResponse).isTrue();
    }

    @Test
    void  terminateOrderTest() throws SaleNotFoundException {
        saleService.addSale(sale);
        Boolean terminateOrderResponse = takeOutSystemService.terminateOrder("test sale");
        assertThat(terminateOrderResponse).isTrue();
    }

    @Test
    void excursionPublicOrderTest() {
        manageDeliveryService.createDelivery(deliveryRequest);
        Delivery delivery = manageDeliveryService.findByName(deliveryRequest.getName());
        log.info("delivery-id->{}", delivery.getId());
        Set<Sale> deliverySet = takeOutSystemService.excursionPublicOrder(delivery.getId());
        assertThat(deliverySet).isNotNull();
        assertThat(deliverySet).containsExactly(delivery.getSale().toArray(new Sale[0]));
    }

    @Test
    void enterStoreTest() {
        manageStoreCrudService.createStore(createStoreRequest);
        Boolean response = takeOutSystemService.enterStore(3L);
        assertThat(takeOutSystemService.getCurrentStore()).isEqualTo(manageStoreCrudService.findStore(3L));
        assertThat(response).isTrue();

    }

    @Test
    void searchTest() {

    }
}