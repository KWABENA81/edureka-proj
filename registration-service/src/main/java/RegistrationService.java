package com.sas.registrationservice.service;

import com.sas.registrationservice.Payment;
import com.sas.registrationservice.Registration;
import com.sas.registrationservice.RegistrationRepository;
import com.sas.registrationservice.TransactionResponse;
import com.sas.registrationservice.entity.Registration;
import com.sas.registrationservice.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.TraceableRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RegistrationService {
    @Autowired
    private
    RestTemplate restTemplate;
    @Autowired
    private RegistrationRepository registrationRepository;

    public TransactionResponse saveRegistration(TraceableRequest request) {
        String response = "";
        Registration registration = request.getRegistration();
        Payment payment = request.getPayment();

        payment.setRegistrationId(registration.getId());
        payment.setAmount(registration.getFee());

        Payment paymentResponse = restTemplate
                .postForObject("http://PAYMENT-SERVICE/payment/doPayment", payment, Payment.class);
        response = paymentResponse.getPaymentStatus().equals("success")
                ? "payment processing successful" : "there is a failure";
        registrationRepository.save(registration);

        return new TransactionResponse();
    }
}
