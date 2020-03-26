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
    private PlaceRepository placeRepository;

    @Override
    public Item createItem(CreateItemRequestDTO requestDTO) throws Exception {
        Item item = new Item();
        item.setName(requestDTO.getName());

        Place place;
        if (requestDTO.getPlaceId() != null) {
            place = placeRepository.findById(requestDTO.getPlaceId()).get();
        } else if (requestDTO.getPlaceName() != null) {
            place = new Place();
            place.setName(requestDTO.getPlaceName());
            placeRepository.save(place);
        } else {
            throw new Exception("Cannot create Item: placeId or placeName should be provided");
        }

        item.setPlace(place);

        itemRepository.save(item);
        return item;
    }

}
