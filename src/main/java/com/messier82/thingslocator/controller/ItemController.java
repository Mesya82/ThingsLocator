package com.messier82.thingslocator.controller;

import com.messier82.thingslocator.dto.CreateItemRequestDTO;
import com.messier82.thingslocator.dto.MoveItemRequestDTO;
import com.messier82.thingslocator.model.Item;
import com.messier82.thingslocator.repository.ItemRepository;
import com.messier82.thingslocator.workflow.CreateItemWorkflow;
import com.messier82.thingslocator.workflow.MoveItemWorkflow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("item")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CreateItemWorkflow createItemWorkflow;

    @Autowired
    private MoveItemWorkflow moveItemWorkflow;

    @GetMapping(produces = "application/json")
    public List<Item> getItemList() {
        return itemRepository.findAll();
    }

    @PostMapping(produces = "application/json")
    public Item createItem(@RequestBody CreateItemRequestDTO requestDTO) throws Exception {
        return createItemWorkflow.createItem(requestDTO);
    }

    @PostMapping(path = "move", produces = "application/json")
    public Item moveItem(@RequestBody MoveItemRequestDTO requestDTO) throws Exception {
        return moveItemWorkflow.moveItem(requestDTO);
    }

}
