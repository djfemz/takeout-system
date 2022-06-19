package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.models.Sale;
import com.takeout.takeout_system.data.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService{
    @Autowired
    private SaleRepository saleRepository;

    @Override
    public Boolean addSale(Sale sale) {
        Sale savedSale = saleRepository.save(sale);
        return savedSale!=null;
    }

    @Override
    public Sale getSaleBy(Long id) {
        return saleRepository.findById(id).orElse(null);
    }

    @Override
    public Sale getSaleBy(String name) {
        return saleRepository.findByName(name);
    }
}
