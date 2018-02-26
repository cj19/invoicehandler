package com.darvasroland.service;

import com.darvasroland.entity.Item;
import com.darvasroland.repository.ItemRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@ManagedBean(name = "ItemService")
@ApplicationScoped
@Stateless
public class ItemService {

    @EJB
    private ItemRepository itemRepository;

    public Item createItem(Item item) {
        return itemRepository.create(item);
    }

    public Item getItemById(Long id) {
        Item item = itemRepository.find(id);
        if (item == null) {
            throw new EntityNotFoundException("Item not found with this id!");
        } else {
            return item;
        }
    }

    public Item updateItem(Item item) {
        return itemRepository.update(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
}
