package com.tnt.beer.inventory.web.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tnt.beer.inventory.model.BeerInventoryDto;
import com.tnt.beer.inventory.repository.BeerInventoryRepository;
import com.tnt.beer.inventory.service.mapper.BeerInventoryMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class BeerInventoryController {

    private final BeerInventoryRepository beerInventoryRepository;
    private final BeerInventoryMapper beerInventoryMapper;

    @GetMapping("api/v1/beer/{beerId}/inventory")
    public ResponseEntity<List<BeerInventoryDto>> listBeersById(@PathVariable UUID beerId){
        log.debug("Finding Inventory for beerId:" + beerId);

        List<BeerInventoryDto> dtos = beerInventoryRepository.findAllByBeerId(beerId)
                .stream()
                .map(beerInventoryMapper::toDto)
                .collect(Collectors.toList());
        
        return new ResponseEntity(dtos, HttpStatus.OK);
    }
}
