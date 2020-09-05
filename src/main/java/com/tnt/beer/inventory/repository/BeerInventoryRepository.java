package com.tnt.beer.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnt.beer.inventory.domain.BeerInventory;

import java.util.List;
import java.util.UUID;

public interface BeerInventoryRepository extends JpaRepository<BeerInventory, UUID> {

    List<BeerInventory> findAllByBeerId(UUID beerId);
}
