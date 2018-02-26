package com.darvasroland.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ITEM")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ITEM_NAME")
    @NotNull
    private String itemName;

    @Column(name = "UNIT_PRICE")
    @NotNull
    private Double unitPrice;

    @Column(name = "QUANTITY")
    @NotNull
    private Integer quantity;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "INVOICES",
            joinColumns = @JoinColumn(name = "ITEM_ID", referencedColumnName = "id"),
            inverseJoinColumns =  @JoinColumn(name = "INVOICE_ID", referencedColumnName = "id")
    )
    private List<Invoice> invoices;

    @Column(name = "TOTAL_PRICE")
    private Double totalPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) &&
                Objects.equals(itemName, item.itemName) &&
                Objects.equals(unitPrice, item.unitPrice) &&
                Objects.equals(quantity, item.quantity) &&
                Objects.equals(invoices, item.invoices) &&
                Objects.equals(totalPrice, item.totalPrice);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, itemName, unitPrice, quantity, invoices, totalPrice);
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
