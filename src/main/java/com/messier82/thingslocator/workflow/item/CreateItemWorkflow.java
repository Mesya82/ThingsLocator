package com.messier82.thingslocator.workflow.item;

import com.messier82.thingslocator.dto.item.CreateItemRequestDTO;
import com.messier82.thingslocator.model.Item;

public interface CreateItemWorkflow {

    Item createItem(CreateItemRequestDTO requestDTO) throws Exception;

}
