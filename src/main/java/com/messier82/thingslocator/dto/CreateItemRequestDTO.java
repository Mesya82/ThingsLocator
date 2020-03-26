package com.messier82.thingslocator.dto;

import lombok.Data;

@Data
public class CreateItemRequestDTO {

    private String name;

    private Long placeId;
    private String placeName;

}
