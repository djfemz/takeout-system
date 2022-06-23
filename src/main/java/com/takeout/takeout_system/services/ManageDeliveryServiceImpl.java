package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.dto.CreateDeliveryRequest;
import com.takeout.takeout_system.data.models.Delivery;
import com.takeout.takeout_system.data.models.Sale;
import com.takeout.takeout_system.data.repositories.DeliveryRepository;
import com.takeout.takeout_system.exceptions.SaleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class ManageDeliveryServiceImpl implements ManageDeliveryService{
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Override
    public Boolean createDelivery(CreateDeliveryRequest createDeliveryRequest) {
        Delivery delivery = new Delivery();
        delivery.setName(createDeliveryRequest.getName());
        delivery.setSale(new HashSet<>());
        deliveryRepository.save(delivery);
        return true;
    }

    @Override
    public Delivery findByName(String name) {
        return deliveryRepository.findByName(name);
    }

    @Override
    public Delivery getDeliveryBy(Long id) {
        return deliveryRepository.findById(id).orElse(null);
    }

    @Override
    public Delivery getCurrentDelivery() {
        return deliveryRepository.findByIsCurrentDeliveryIsTrue();
    }

    @Override
    public Boolean acceptOrder(String name) throws SaleNotFoundException {
        return null;
    }

    @Override
    public Boolean terminateOrder(String name) throws SaleNotFoundException {
        return null;
    }

    @Override
    public Set<Sale> excursionPublicOrder(Long id) {
        return null;
    }
}
