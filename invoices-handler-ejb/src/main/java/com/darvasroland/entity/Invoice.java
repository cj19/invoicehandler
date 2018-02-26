package com.darvasroland.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "INVOICE")
public class Invoice implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CUSTOMER_NAME", length = 50, unique = true)
    @NotNull
    private String customerName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ISSUE_DATE")
    @NotNull
    private Date issueDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DUE_DATE")
    @NotNull
    private Date dueDate;

    @Column(name = "COMMENT")
    private String comment;

    @XmlTransient
    @ManyToMany(mappedBy = "invoices", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Item> items;

    @Column(name = "TOTAL_COST")
    private Double totalCost;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(id, invoice.id) &&
                Objects.equals(customerName, invoice.customerName) &&
                Objects.equals(issueDate, invoice.issueDate) &&
                Objects.equals(dueDate, invoice.dueDate) &&
                Objects.equals(comment, invoice.comment) &&
                Objects.equals(items, invoice.items) &&
                Objects.equals(totalCost, invoice.totalCost);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, customerName, issueDate, dueDate, comment, items, totalCost);
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String name) {
        this.customerName = name;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }
}
