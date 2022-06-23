package com.takeout.takeout_system.controllers;

import com.takeout.takeout_system.services.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    private AdministratorService administratorService;
}
