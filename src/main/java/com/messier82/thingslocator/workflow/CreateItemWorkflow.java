package com.messier82.thingslocator.workflow;

import com.messier82.thingslocator.dto.CreateItemRequestDTO;
import com.messier82.thingslocator.model.Item;

public interface CreateItemWorkflow {

    Item createItem(CreateItemRequestDTO requestDTO) throws Exception;

}
