package com.sas.feems.service;

import com.sas.feems.model.Fee;
import com.sas.feems.repo.FeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FeeService implements IFeeService {

    @Autowired
    FeeRepository feeRepository;

    public Fee findById(Integer id) {
        Optional<Fee> optionalFee = feeRepository.findById(id);
        return (optionalFee.isPresent())
                ? optionalFee.get() : optionalFee.orElseThrow();
    }

    public Fee save(Fee fee) {
        return feeRepository.save(fee);
    }


    public Collection<Fee> findAll() {
        return feeRepository.findAll();
    }

    public List<Fee> findBySID(String sid) {
        return findAll().stream()
                .filter(s -> s.getSid().equalsIgnoreCase(sid)).collect(Collectors.toList());
    }
}
