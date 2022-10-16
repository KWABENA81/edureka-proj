package com.sas.feems.service;

import com.sas.feems.FeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeeService implements IFeeService {

    @Autowired
    FeeRepository feeRepository;
}
