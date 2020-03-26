package com.messier82.thingslocator.dto;

import lombok.Data;

@Data
public class MoveItemRequestDTO {

    private Long itemId;
    private Long placeId;
    private String placeName;

}
