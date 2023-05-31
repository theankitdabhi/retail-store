package com.retail.store.service;

import com.retail.store.modal.Bill;
import com.retail.store.modal.NetAmount;

public interface DiscountService {
    NetAmount calculateNetPayableAmount(Bill bill);
}