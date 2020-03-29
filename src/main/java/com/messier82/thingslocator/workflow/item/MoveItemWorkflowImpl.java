package com.messier82.thingslocator.workflow.item;

import com.messier82.thingslocator.dto.item.MoveItemRequestDTO;
import com.messier82.thingslocator.model.Item;
import com.messier82.thingslocator.model.Place;
import com.messier82.thingslocator.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MoveItemWorkflowImpl implements MoveItemWorkflow {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private GetOrCreatePlaceWorkflow getOrCreatePlaceWorkflow;

    @Override
    public Item moveItem(MoveItemRequestDTO requestDTO) throws Exception {
        Optional<Item> optionalItem = itemRepository.findById(requestDTO.getItemId());

        if (optionalItem.isEmpty()) {
            throw new Exception(String.format("Cannot move Item: Item with specified [id=%d] does not exist", requestDTO.getItemId()));
        }

        Place place = getOrCreatePlaceWorkflow.getOrCreatePlace(requestDTO.getPlaceId(), requestDTO.getPlaceName());

        Item item = optionalItem.get();
        item.setPlace(place);
        itemRepository.save(item);
        return item;
    }
}
