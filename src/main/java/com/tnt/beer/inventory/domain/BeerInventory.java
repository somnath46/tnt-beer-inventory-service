package com.tnt.beer.inventory.domain;

import java.time.Instant;
import java.util.UUID;

import javax.persistence.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by jt on 2019-01-26.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class BeerInventory extends BaseEntity{

    @Builder
    public BeerInventory(UUID id, Long version, Instant createdDate, Instant lastModifiedDate, UUID beerId,
                         String upc, Integer quantityOnHand) {
        super(id, version, createdDate, lastModifiedDate);
        this.beerId = beerId;
        this.upc = upc;
        this.quantityOnHand = quantityOnHand;
    }

    private UUID beerId;
    private String upc;
    private Integer quantityOnHand = 0;
}
