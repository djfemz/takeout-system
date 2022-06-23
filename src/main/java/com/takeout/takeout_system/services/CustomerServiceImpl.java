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
    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean makeNewOrder() {
        return null;
    }

    @Override
    public boolean enterItem(EnterItemRequest enterItemRequest) {
        return false;
    }

    @Override
    public BigDecimal endOrder() {
        return null;
    }

    @Override
    public Boolean makeCashPayment(BigDecimal amount) {
        return null;
    }

    @Override
    public Item search(String name) {
        return null;
    }

    @Override
    public Boolean enterStore(Long id) {
        return null;
    }

    @Override
    public Sale getSale(Long id) {
        return null;
    }
}
