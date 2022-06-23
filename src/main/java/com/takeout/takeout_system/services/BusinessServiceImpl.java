package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.dto.CreateItemRequest;
import com.takeout.takeout_system.data.dto.ModifyItemRequest;
import com.takeout.takeout_system.data.models.Item;
import com.takeout.takeout_system.data.models.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BusinessServiceImpl implements BusinessService{
    @Autowired
    private SaleService saleService;
    @Autowired
    private ManageItemCrudService manageItemCrudService;
    @Autowired
    private TakeOutSystemService takeOutSystemService;

    @Override
    public Boolean enterStore(Long id) {
        return takeOutSystemService.enterStore(id);
    }

    @Override
    public Sale getSaleBy(Long id) {
        return saleService.getSaleBy(id);
    }

    @Override
    public Sale getSaleBy(String name) {
        return saleService.getSaleBy(name);
    }

    @Override
    public Boolean createItem(CreateItemRequest createItemRequest) {
        return manageItemCrudService.createItem(createItemRequest);
    }

    @Override
    public Item findItem(Long id) {
        return manageItemCrudService.findItem(id);
    }

    @Override
    public Item findBy(String name) {
        return manageItemCrudService.findBy(name);
    }

    @Override
    public Boolean modifyItem(Long id, ModifyItemRequest modifyItemRequest) {
        return manageItemCrudService.modifyItem(id, modifyItemRequest);
    }

    @Override
    public Boolean deleteItem(Long id) {
        return manageItemCrudService.deleteItem(id);
    }

    @Override
    public Item saveItem(Item item) {
        return manageItemCrudService.saveItem(item);
    }

    @Override
    public List<Item> getAllItems() {
        return manageItemCrudService.getAllItems();
    }

    @Override
    public Set<Sale> excursionPublicOrder(Long id) {
        return takeOutSystemService.excursionPublicOrder(id);
    }
}
