package com.sas.feems.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "FEE")
public class Fee implements Comparable<Fee> {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "DUEDATE")
    private LocalDate dueDate;
    @Column(name = "AMOUNT", nullable = false)
    private Float amount;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "SID", nullable = false)
    private String sid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate feeDate) {
        this.dueDate = feeDate;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Override
    public int compareTo(Fee fee) {
        return (this.sid.compareTo(fee.sid) == 0)
                ? this.dueDate.compareTo(fee.dueDate) : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fee)) return false;
        Fee fee = (Fee) o;
        return getDueDate().equals(fee.getDueDate()) && getStatus().equals(fee.getStatus()) && getSid().equals(fee.getSid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDueDate(), getStatus(), getSid());
    }

    @Override
    public String toString() {
        return "Fee{" +
                "dueDate=" + dueDate +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", sid='" + sid + '\'' +
                '}';
    }
}



