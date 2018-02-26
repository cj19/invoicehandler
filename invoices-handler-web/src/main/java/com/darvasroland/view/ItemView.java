package com.darvasroland.view;


import com.darvasroland.entity.Item;
import com.darvasroland.service.ItemService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "ItemView")
@ViewScoped
public class ItemView implements Serializable {

    private Long selectItemId;

    private String ITEM_ID = "item_id";

    private List<Item> items;

    private List<Item> filteredItems;

    private Item item;

    @Inject
    private ItemService itemService;

    @PostConstruct
    public void init() {
        items = itemService.getAllItems();
    }

    public Long getSelectItemId() {
        return selectItemId;
    }

    public void setSelectItemId(Long selectItemId) {
        this.selectItemId = selectItemId;
    }

    public String getITEM_ID() {
        return ITEM_ID;
    }

    public void setITEM_ID(String ITEM_ID) {
        this.ITEM_ID = ITEM_ID;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ItemService getItemService() {
        return itemService;
    }

    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    public List<Item> getFilteredItems() {
        return filteredItems;
    }

    public void setFilteredItems(List<Item> filteredItems) {
        this.filteredItems = filteredItems;
    }
}
