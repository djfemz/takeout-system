package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.dto.CreateDeliveryRequest;
import com.takeout.takeout_system.data.models.Delivery;

public interface ManageDeliveryService {
    Boolean createDelivery(CreateDeliveryRequest createDeliveryRequest);
    Delivery findByName(String name);
    Delivery getDeliveryBy(Long id);
    Delivery getCurrentDelivery();
}
