package com.messier82.thingslocator.workflow;

import com.messier82.thingslocator.model.Place;
import com.messier82.thingslocator.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetOrCreatePlaceWorkflowImpl implements GetOrCreatePlaceWorkflow {

    @Autowired
    private PlaceRepository placeRepository;

    @Override
    public Place getOrCreatePlace(Long placeId, String placeName) throws Exception {
        Place place;
        if (placeId != null) {
            place = placeRepository.findById(placeId).get();
        } else if (placeName != null) {
            place = new Place();
            place.setName(placeName);
            placeRepository.save(place);
        } else {
            throw new Exception("Cannot create Item: placeId or placeName should be provided");
        }
        return place;
    }
}
