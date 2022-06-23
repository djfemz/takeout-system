package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.dto.EnterItemRequest;
import com.takeout.takeout_system.data.models.Customer;
import com.takeout.takeout_system.data.models.Item;
import com.takeout.takeout_system.data.models.Sale;
import com.takeout.takeout_system.data.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private TakeOutSystemService takeOutSystemService;

    @Autowired
    private ProcessOrderService processOrderService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SaleService saleService;

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean makeNewOrder() {
        return processOrderService.makeNewOrder();
    }

    @Override
    public boolean enterItem(EnterItemRequest enterItemRequest) {
        return processOrderService.enterItem(enterItemRequest);
    }

    @Override
    public BigDecimal endOrder() {
        return processOrderService.endOrder();
    }

    @Override
    public Boolean makeCashPayment(BigDecimal amount) {
        return processOrderService.makeCashPayment(amount);
    }

    @Override
    public Item search(String name) {
        return takeOutSystemService.search(name);
    }

    @Override
    public Boolean enterStore(Long id) {
        return takeOutSystemService.enterStore(id);
    }

    @Override
    public Sale getSale(Long id) {
        return saleService.getSaleBy(id);
    }
}
