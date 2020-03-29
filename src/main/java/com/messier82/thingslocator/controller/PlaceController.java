package com.messier82.thingslocator.controller;

import com.messier82.thingslocator.dto.place.CreatePlaceRequestDTO;
import com.messier82.thingslocator.model.Place;
import com.messier82.thingslocator.repository.PlaceRepository;
import com.messier82.thingslocator.workflow.place.CreatePlaceWorkflow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("place")
public class PlaceController {

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private CreatePlaceWorkflow createPlaceWorkflow;

    @GetMapping(produces = "application/json")
    public List<Place> getPlaceList() {
        return placeRepository.findAll();
    }

    @PostMapping(produces = "application/json")
    public Place createPlace(@RequestBody CreatePlaceRequestDTO requestDTO) {
        return createPlaceWorkflow.createPlace(requestDTO);
    }

}
