package com.messier82.thingslocator.workflow.place;

import com.messier82.thingslocator.model.Place;
import com.messier82.thingslocator.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdatePlaceWorkflowImpl implements UpdatePlaceWorkflow {

    @Autowired
    private PlaceRepository placeRepository;

    @Override
    public Place updatePlace(Place place) throws Exception {
        if (place.getId() == null) {
            throw new Exception("Cannot update Place: id of the Place to update must be provided");
        }

        Optional<Place> optionalPlace = placeRepository.findById(place.getId());

        if (optionalPlace.isEmpty()) {
            throw new Exception(String.format("Cannot update Place: Place with [id=%d] does not exist", place.getId()));
        }

        return placeRepository.save(place);
    }
}
