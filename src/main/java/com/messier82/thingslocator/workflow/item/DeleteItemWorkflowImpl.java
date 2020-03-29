package com.messier82.thingslocator.workflow.item;

import com.messier82.thingslocator.model.Item;
import com.messier82.thingslocator.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteItemWorkflowImpl implements DeleteItemWorkflow {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public void deleteItem(Long itemId) throws Exception {
        Optional<Item> optionalItem = itemRepository.findById(itemId);

        if (optionalItem.isEmpty()) {
            throw new Exception(String.format("Cannot delete Item: item with [id=%d] does not exist", itemId));
        }

        itemRepository.delete(optionalItem.get());
    }
}
