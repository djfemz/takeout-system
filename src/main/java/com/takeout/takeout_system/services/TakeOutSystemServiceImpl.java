package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.models.Item;
import com.takeout.takeout_system.data.models.Sale;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TakeOutSystemServiceImpl implements TakeOutSystemService {
    @Override
    public Boolean acceptOrder(String name) {
        return null;
    }

    @Override
    public Boolean terminateOrder(String name) {
        return null;
    }

    @Override
    public Set<Sale> excursionPublicOrder(String id) {
        return null;
    }

    @Override
    public Boolean enterStore(Integer id) {
        return null;
    }

    @Override
    public Item search(String name) {
        return null;
    }
}
