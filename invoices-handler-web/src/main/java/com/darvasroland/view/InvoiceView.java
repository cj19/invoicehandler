package com.darvasroland.view;

import com.darvasroland.entity.Invoice;
import com.darvasroland.entity.Item;
import com.darvasroland.service.InvoiceService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "InvoiceView")
@SessionScoped
public class InvoiceView implements Serializable {

    private Long selectedInvoiceId;

    private String INVOICE_ID = "invoice_id";

    private List<Invoice> invoices;

    private List<Invoice> selectedInvoices;

    private List<Invoice> filteredInvoices;

    private List<Item> invoiceItems;

    private Item invoiceItem;

    private Invoice invoice;

    @Inject
    private InvoiceService invoiceService;

    @PostConstruct
    public void init() {
        invoices = invoiceService.getAllInvoices();
    }

    public String viewInvoice() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params
                = fc.getExternalContext().getRequestParameterMap();
        selectedInvoiceId= Long.parseLong(params.get(INVOICE_ID));
        invoice = invoiceService.getInvoiceById(selectedInvoiceId);
        invoiceItems = invoice.getItems();
        return "/dataviews/view_invoice.xhtml?faces-redirect=true";
    }

    public String refreshView(){
        invoices = invoiceService.getAllInvoices();
        return "index.xhtml?faces-redirect=true";
    }

    public Long getSelectedInvoiceId() {
        return selectedInvoiceId;
    }

    public void setSelectedInvoiceId(Long selectedInvoiceId) {
        this.selectedInvoiceId = selectedInvoiceId;
    }

    public String getINVOICE_ID() {
        return INVOICE_ID;
    }

    public void setINVOICE_ID(String INVOICE_ID) {
        this.INVOICE_ID = INVOICE_ID;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
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

    public List<Invoice> getSelectedInvoices() {
        return selectedInvoices;
    }

    public void setSelectedInvoices(List<Invoice> selectedInvoices) {
        this.selectedInvoices = selectedInvoices;
    }

    public List<Invoice> getFilteredInvoices() {
        return filteredInvoices;
    }

    public void setFilteredInvoices(List<Invoice> filteredInvoices) {
        this.filteredInvoices = filteredInvoices;
    }

    public List<Item> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(List<Item> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }

    public Item getInvoiceItem() {
        return invoiceItem;
    }

    public void setInvoiceItem(Item invoiceItem) {
        this.invoiceItem = invoiceItem;
    }
}
