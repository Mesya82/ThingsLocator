package com.messier82.thingslocator.workflow.item;

import com.messier82.thingslocator.dto.item.MoveItemRequestDTO;
import com.messier82.thingslocator.model.Item;

public interface MoveItemWorkflow {

    Item moveItem(MoveItemRequestDTO requestDTO) throws Exception;

}
