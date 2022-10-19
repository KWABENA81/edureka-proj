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
    @Column(name = "feetype")
    private String feeType;
    @Column(name = "duedate")
    private LocalDate dueDate;
    @Column(name = "amount", nullable = false)
    private Float amount;

    @Column(name = "status")
    private String status;

    @Column(name = "studentid", nullable = false)
    private String studentId;


    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fee)) return false;
        Fee fee = (Fee) o;
        return Objects.equals(getStudentId(),
                fee.getStudentId()) && Objects.equals(getFeeType(),
                fee.getFeeType()) && Objects.equals(getDueDate(),
                fee.getDueDate()) && Objects.equals(getAmount(), fee.getAmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId(), getFeeType(), getDueDate(), getAmount());
    }

    @Override
    public int compareTo(Fee fee) {
        return 0;
    }

    @Override
    public String toString() {
        return "Fee{" + "id=" + id + ", feeType='" + feeType + '\''
                + ", amount=" + amount + ", status='" + status + '\'' + '}';
    }

}



