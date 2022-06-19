package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.dto.CreateDeliveryRequest;
import com.takeout.takeout_system.data.models.Delivery;
import com.takeout.takeout_system.data.repositories.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ManageDeliveryServiceImpl implements ManageDeliveryService{
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Override
    public Boolean createDelivery(CreateDeliveryRequest createDeliveryRequest) {
        Delivery delivery = new Delivery();
        delivery.setName(createDeliveryRequest.getName());
        delivery.setSale(new ArrayList<>());
        deliveryRepository.save(delivery);
        return true;
    }
}
