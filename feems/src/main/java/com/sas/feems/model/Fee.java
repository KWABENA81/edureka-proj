package com.sas.feems.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "FEE")
public class Fee implements Comparable<Fee> , Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "feetype", nullable = false)
    private String feeType;

    @Column(name = "amount", nullable = false)
    private Float amount;

    @Column(name = "status", nullable = false)
    private String status;

    private String studentId;

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

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fee fee)) return false;
        return getStudentId().equals(fee.getStudentId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId());
    }

    @Override
    public int compareTo(Fee fee) {
        return 0;
    }

    @Override
    public String toString() {
        return "Fee{" +
                "id=" + id +
                ", feeType='" + feeType + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", studentId='" + studentId + '\'' +
                '}';
    }
}



