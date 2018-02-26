package com.darvasroland.controller;

import com.darvasroland.entity.Invoice;
import com.darvasroland.entity.Item;
import com.darvasroland.service.InvoiceService;
import com.darvasroland.service.ItemService;
import com.darvasroland.util.Message;
import com.darvasroland.util.Popup;

import javax.annotation.PostConstruct;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@ManagedBean(name = "AddNewInvoiceAndItem")
@ViewScoped
public class AddNewInvoiceAndItemController implements Serializable {

    private Invoice invoice;

    private List<Item> items;

    private Item item;

    private double unitPrice;

    private int quantity;

    private double totalPrice;

    private double totalCost;

    private Item newItem;

    @Inject
    private InvoiceService invoiceService;

    @Inject
    private ItemService itemService;

    @Inject
    private Logger logger;

    @PostConstruct
    public void init() {
        items=new ArrayList<>();
        invoice = new Invoice();
        invoice.setItems(new ArrayList<Item>());
        newItem = new Item();
        unitPrice = 0.0;
        quantity = 0;
        totalPrice = 0.0;
    }

    public String createInvoice() {
        setInvoiceInItems();
        invoice.setItems(items);
        invoiceService.createInvoice(invoice);
        Popup.pushPopup(Message.INVOICE_ADD_SUCCESS_BODY, Message.INVOICE_ADD_SUCCESS_HEADER);
        return "/dataviews/add_invoice.xhtml?faces-redirect=true";
    }

    private void setInvoiceInItems() {
        for (Item item: items) {
            item.getInvoices().add(invoice);
        }
    }

    public void updateDataTable() {
        items = itemService.getAllItems();
    }

    public void updateTotalPrice() {
        totalPrice = unitPrice * quantity;
    }

    public void createItem() {
        newItem.setUnitPrice(unitPrice);
        newItem.setQuantity(quantity);
        newItem.setTotalPrice(totalPrice);
        totalCost += newItem.getTotalPrice();
        invoice.setTotalCost(totalCost);
        newItem.setInvoices(new ArrayList<Invoice>());
        items.add(newItem);
        Popup.pushPopup(Message.ITEM_ADD_SUCCESS_BODY, Message.ITEM_ADD_SUCCESS_HEADER);
        newItem = new Item();
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public InvoiceService getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    public ItemService getItemService() {
        return itemService;
    }

    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
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

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Item getNewItem() {
        return newItem;
    }

    public void setNewItem(Item newItem) {
        this.newItem = newItem;
    }
}
