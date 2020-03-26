package com.messier82.thingslocator.workflow;

import com.messier82.thingslocator.model.Place;

public interface GetOrCreatePlaceWorkflow {

    Place getOrCreatePlace(Long placeId, String placeName) throws Exception;

}
