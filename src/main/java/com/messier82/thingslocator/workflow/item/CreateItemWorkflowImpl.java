package com.messier82.thingslocator.workflow.item;

import com.messier82.thingslocator.dto.CreateItemRequestDTO;
import com.messier82.thingslocator.model.Item;
import com.messier82.thingslocator.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateItemWorkflowImpl implements CreateItemWorkflow {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private GetOrCreatePlaceWorkflow getOrCreatePlaceWorkflow;

    @Override
    public Item createItem(CreateItemRequestDTO requestDTO) throws Exception {
        Item item = new Item();
        item.setName(requestDTO.getName());
        item.setPlace(getOrCreatePlaceWorkflow.getOrCreatePlace(requestDTO.getPlaceId(), requestDTO.getPlaceName()));
        itemRepository.save(item);
        return item;
    }

}
