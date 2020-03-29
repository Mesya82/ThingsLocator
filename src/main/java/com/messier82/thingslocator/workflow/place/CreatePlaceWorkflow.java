package com.messier82.thingslocator.workflow.place;

import com.messier82.thingslocator.dto.place.CreatePlaceRequestDTO;
import com.messier82.thingslocator.model.Place;

public interface CreatePlaceWorkflow {

    Place createPlace(CreatePlaceRequestDTO requestDTO);

}
