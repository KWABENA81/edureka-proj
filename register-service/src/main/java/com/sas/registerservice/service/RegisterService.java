package com.sas.registerservice.service;

import com.sas.registerservice.common.Payment;
import com.sas.registerservice.common.TransactionRequest;
import com.sas.registerservice.common.TransactionResponse;
import com.sas.registerservice.entity.Register;
import com.sas.registerservice.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RegisterService {
    @Autowired
    private
    RestTemplate restTemplate;
    @Autowired
    private RegisterRepository registerRepository;

    public TransactionResponse saveRegister(TransactionRequest request) {
        String response = "";
        Register register = request.getRegister();
        Payment payment = request.getPayment();

        payment.setRegisterId(register.getId());
        payment.setAmount(register.getPayableFees());

        Payment paymentResponse = restTemplate
                .postForObject("http://PAYMENT-SERVICE/payment/doPayment", payment, Payment.class);
        response = paymentResponse.getPaymentStatus().equals("success")
                ? "payment processing successful" : "there is a failure";
        registerRepository.save(register);

        return new TransactionResponse();
    }
}
