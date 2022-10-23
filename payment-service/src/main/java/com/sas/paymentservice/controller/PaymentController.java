package com.sas.paymentservice.controller;

import com.sas.paymentservice.entity.Payment;
import com.sas.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody Payment payment) {
        return paymentService.doPayment((payment));
    }

    @GetMapping("{registerId}")
    public Payment findPaymentHistoryByRegisterId(int registerId) {
        return paymentService.findPaymentHistoryByRegisterId(registerId);
    }

}
