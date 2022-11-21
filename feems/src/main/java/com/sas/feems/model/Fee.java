package com.sas.feems.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;


@Entity
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "FEE")
public class Fee implements Comparable<Fee> {
    @Id
    @SequenceGenerator(name = "fee_id_sequence", sequenceName = "fee_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fee_id_sequence")
    //@Column(name = "ID", nullable = false)
    private Integer id;

    //@Column(name = "DUEDATE")
    private LocalDate dueDate;
    //@Column(name = "AMOUNT", nullable = false)
    private Float amount;

    //@Column(name = "STATUS")    private String status;

    //@Column(name = "SID", nullable = false)
    private String studentId;
//
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Float getAmount() {
//        return amount;
//    }
//
//    public void setAmount(Float amount) {
//        this.amount = amount;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public LocalDate getDueDate() {
//        return dueDate;
//    }
//
//    public void setDueDate(LocalDate feeDate) {
//        this.dueDate = feeDate;
//    }
//
//    public String getSid() {
//        return sid;
//    }
//
//    public void setSid(String sid) {
//        this.sid = sid;
//    }

    @Override
    public int compareTo(Fee fee) {
        return (this.studentId.compareTo(fee.studentId) == 0)
                ? this.dueDate.compareTo(fee.dueDate) : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fee)) return false;
        Fee fee = (Fee) o;
        return this.dueDate.equals(fee.dueDate) && this.studentId.equals(fee.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.dueDate, this.studentId);
    }

    @Override
    public String toString() {
        return "Fee{" + "dueDate=" + dueDate + ", amount=" + '\'' + ", studentId='" + studentId + '\'' + '}';
    }
}



