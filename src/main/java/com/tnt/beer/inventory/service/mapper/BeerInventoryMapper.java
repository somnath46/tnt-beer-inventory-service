package com.tnt.beer.inventory.service.mapper;

import org.mapstruct.Mapper;

import com.tnt.beer.inventory.domain.BeerInventory;
import com.tnt.beer.inventory.model.BeerInventoryDto;

@Mapper(componentModel = "spring", uses = {DateMapper.class})
public interface BeerInventoryMapper extends BaseMapper<BeerInventoryDto, BeerInventory> {

	@Override
    BeerInventory fromDto(BeerInventoryDto beerInventoryDTO);

	@Override
    BeerInventoryDto toDto(BeerInventory beerInventory);
}
