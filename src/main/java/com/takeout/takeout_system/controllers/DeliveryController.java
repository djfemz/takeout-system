package com.takeout.takeout_system.controllers;

import com.takeout.takeout_system.services.ManageDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryController {
    @Autowired
    private ManageDeliveryService manageDeliveryService;
}
