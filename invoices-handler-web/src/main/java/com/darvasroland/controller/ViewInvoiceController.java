package com.darvasroland.controller;

import com.darvasroland.entity.Invoice;
import com.darvasroland.entity.Item;
import com.darvasroland.service.InvoiceService;
import com.darvasroland.view.InvoiceView;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "ViewInvoiceController")
@ViewScoped
public class ViewInvoiceController implements Serializable {

    private InvoiceView invoiceView;

    private Invoice invoice;

    private List<Item> invoiceItems;

    @Inject
    private InvoiceService invoiceService;

    @PostConstruct
    public void init() {
        invoice = invoiceService.getInvoiceById(invoiceView.getSelectedInvoiceId());
    }

    public InvoiceView getInvoiceView() {
        return invoiceView;
    }

    public void setInvoiceView(InvoiceView invoiceView) {
        this.invoiceView = invoiceView;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public List<Item> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(List<Item> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }
}
