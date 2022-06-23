package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.dto.FindSaleResponse;
import com.takeout.takeout_system.data.models.Sale;
import com.takeout.takeout_system.data.repositories.SaleRepository;
import com.takeout.takeout_system.exceptions.SaleNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService{
    @Autowired
    private SaleRepository saleRepository;
    private final ModelMapper mapper= new ModelMapper();

    @Override
    public Boolean addSale(Sale sale) {
        saleRepository.save(sale);
        return true;
    }

    @Override
    public FindSaleResponse getSaleBy(Long id) {
        Sale sale = saleRepository.findById(id)
                .orElseThrow(()->new SaleNotFoundException(String.format("sale with id %d not found", id)));
       return mapper.map(sale, FindSaleResponse.class);
    }

    @Override
    public Sale getCurrentSale(){
        return saleRepository.findByIsCurrentSaleIsTrue();
    }

    @Override
    public FindSaleResponse getSaleBy(String name) {
        Sale sale = saleRepository.findByName(name);
        return mapper.map(sale, FindSaleResponse.class);
    }
}
