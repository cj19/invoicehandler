package com.darvasroland.repository;

import com.darvasroland.entity.Invoice;

import javax.ejb.Stateless;

@Stateless
public class InvoiceRepository extends EntityRepositoryFacade<Invoice> {

    public InvoiceRepository() {
        super(Invoice.class);
    }
}
