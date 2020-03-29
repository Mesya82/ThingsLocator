package com.messier82.thingslocator.workflow.place;

import com.messier82.thingslocator.dto.place.CreatePlaceRequestDTO;
import com.messier82.thingslocator.model.Place;
import com.messier82.thingslocator.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatePlaceWorkflowImpl implements CreatePlaceWorkflow {

    @Autowired
    private PlaceRepository placeRepository;

    @Override
    public Place createPlace(CreatePlaceRequestDTO requestDTO) {
        Place place = new Place();
        place.setName(requestDTO.getName());
        place.setLocationDescription(requestDTO.getLocationDescription());
        placeRepository.save(place);
        return place;
    }
}
