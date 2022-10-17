package com.sas.feems.model;

import javax.persistence.*;


@Table(name = "FEE")
@Entity //@Component
public class Fee implements Comparable<Fee> {

    private static final long serialVersionUID = 1L;
    private String studentId;
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
    //    @Autowired
    //private Student student;


//    @Autowired
//    public Fee( Student student) {
//        this.student = student;
//    }


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

//    @PostConstruct     public void init(){
//        student.setFee(this);
//    } public Student getStudent(){
//        return student;
//    }


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "STUDENT_ID"/*, referencedColumnName = "ID"*/)
//@JsonBackReference//("fee")
//    private Student student;
//
//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }


    @Override
    public int compareTo(Fee fee) {
        return 0;
    }

    @Override
    public String toString() {
        return "Fee{" + "id=" + id + ", feeType='" + feeType + '\'' + ", amount=" + amount + ", status='" + status + '\'' + '}';
    }

}



