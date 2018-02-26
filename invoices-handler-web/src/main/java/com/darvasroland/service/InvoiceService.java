package com.darvasroland.service;

import com.darvasroland.entity.Invoice;
import com.darvasroland.repository.InvoiceRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@ManagedBean(name = "InvoiceService")
@ApplicationScoped
@Stateless
public class InvoiceService {

    @EJB
    private InvoiceRepository invoiceRepository;

    public Invoice createInvoice(Invoice invoice){
        return invoiceRepository.create(invoice);
    }

    public Invoice getInvoiceById(Long id) {
        Invoice invoice = invoiceRepository.find(id);
        if (invoice == null) {
            throw new EntityNotFoundException("Invoice not found with this id!");
        } else {
            return invoice;
        }
    }

    public Invoice updateInvoice(Invoice invoice) {
        return invoiceRepository.update(invoice);
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

}
