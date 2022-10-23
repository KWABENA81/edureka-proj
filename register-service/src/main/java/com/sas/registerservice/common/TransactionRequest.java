package com.sas.registerservice.common;

import com.sas.registerservice.entity.Register;

public class TransactionRequest {
    private Register register;
    private Payment payment;

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
