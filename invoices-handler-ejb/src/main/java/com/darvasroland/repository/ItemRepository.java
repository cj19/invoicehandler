package com.darvasroland.repository;

import com.darvasroland.entity.Item;

import javax.ejb.Stateless;

@Stateless
public class ItemRepository extends EntityRepositoryFacade<Item> {

    protected ItemRepository() {
        super(Item.class);
    }
}
