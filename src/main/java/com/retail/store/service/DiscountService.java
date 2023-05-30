package com.retail.store.service;

import com.retail.store.modal.Bill;

public interface DiscountService {
    double calculateNetPayableAmount(Bill bill);
}