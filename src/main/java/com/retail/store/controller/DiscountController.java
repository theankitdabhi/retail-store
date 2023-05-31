package com.retail.store.controller;

import com.retail.store.modal.Bill;
import com.retail.store.modal.NetAmount;
import com.retail.store.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscountController {

    private final DiscountService discountService;

    @Autowired
    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }
    
    @PostMapping("/calculateNetPayableAmount")
    public NetAmount calculateNetPayableAmount(@RequestBody Bill bill) {
        return discountService.calculateNetPayableAmount(bill);
    }
}