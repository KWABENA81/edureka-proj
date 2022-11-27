package com.sas.feems.api;

import com.sas.feems.model.Fee;
import com.sas.feems.service.FeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("api/v1/fees")
public class FeeResource {

    @Autowired
    private FeeService feeService;

    @GetMapping("/feeGetTest")
    public String getFeeResourceTest() {
        return "Running Fee resource get mapping test";
    }

    @GetMapping("/fees")
    public List<Fee> getAllFees() {
        return feeService.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/studentId/{sid}")
    public List<Fee> getStudentFees(@PathVariable String sid) {
        return feeService.findBySID(sid).stream().collect(Collectors.toList());
    }

    @PutMapping("/fees/{id}")
    public Fee updateFee(@RequestBody Fee fee, @PathVariable Integer id) {
        Fee fee_db = feeService.findById(id);
        if (fee_db != null) {

            fee_db.setAmount(fee.getAmount());
            fee_db.setStatus(fee.getStatus());
            return feeService.save(fee_db);
        } else {
            fee.setId(id);
            return feeService.save(fee);
        }
    }

//    @PutMapping("/fees/{id}")
//    public Fee payFee(@RequestBody Fee fee, @PathVariable Integer id) {
//        return updateFee(fee, id);
//    }
}