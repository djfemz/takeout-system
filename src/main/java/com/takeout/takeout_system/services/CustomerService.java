package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.models.Customer;

public interface CustomerService {
    Customer getCustomerById(String id);
}
