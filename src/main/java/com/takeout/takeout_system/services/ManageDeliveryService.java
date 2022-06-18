package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.dto.CreateDeliveryRequest;

public interface ManageDeliveryService {
    Boolean createDelivery(CreateDeliveryRequest createDeliveryRequest);
}
