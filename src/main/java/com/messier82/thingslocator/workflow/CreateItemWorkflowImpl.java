package com.messier82.thingslocator.workflow;

import com.messier82.thingslocator.dto.CreateItemRequestDTO;
import com.messier82.thingslocator.model.Item;
import com.messier82.thingslocator.model.Place;
import com.messier82.thingslocator.repository.ItemRepository;
import com.messier82.thingslocator.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
