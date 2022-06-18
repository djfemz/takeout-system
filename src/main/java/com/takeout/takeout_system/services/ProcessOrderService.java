package com.takeout.takeout_system.services;

import com.takeout.takeout_system.data.dto.EnterItemRequest;

public interface ProcessOrderService {
    Boolean makeNewOrder();
    Boolean enterItem(EnterItemRequest enterItemRequest);

}
