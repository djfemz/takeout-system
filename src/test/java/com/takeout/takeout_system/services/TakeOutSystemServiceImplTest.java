package com.takeout.takeout_system.services;


import com.takeout.takeout_system.data.models.Sale;
import com.takeout.takeout_system.data.models.Store;
import com.takeout.takeout_system.exceptions.SaleNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TakeOutSystemServiceImplTest {
    @Autowired
    private TakeOutSystemService takeOutSystemService;
    @Autowired
    private SaleService saleService;
    private Sale sale;

    @BeforeEach
    void setUp(){
        sale = new Sale();
        sale.setName("test sale");
        sale.setStore(new Store("test store", "test address"));
        saleService.addSale(sale);

    }

    @Test
    void acceptOrderTest() throws SaleNotFoundException {
       Boolean acceptOrderResponse = takeOutSystemService.acceptOrder("test sale");
       assertThat(acceptOrderResponse).isTrue();
    }

    @Test
    void  terminateOrderTest() {
    }

    @Test
    void excursionPublicOrderTest() {
    }

    @Test
    void enterStoreTest() {

    }

    @Test
    void searchTest() {

    }
}