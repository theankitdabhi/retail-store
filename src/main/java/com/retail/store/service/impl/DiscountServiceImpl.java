package com.retail.store.service.impl;

import com.retail.store.modal.Bill;
import com.retail.store.service.DiscountService;
import org.springframework.stereotype.Service;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Override
    public double calculateNetPayableAmount(Bill bill) {
        try {
            double discount = 0;
            if (!bill.isGroceries()) {
                discount = calculatePercentageBasedDiscount(bill);
                if (discount == 0) {
                    discount = calculateYearsBasedDiscount(bill);
                }
            }
            discount = calculateDiscountOnTotalAmount(bill, discount);
            double netPayableAmount = bill.totalAmount() - discount;
            return Math.max(netPayableAmount, 0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static double calculateDiscountOnTotalAmount(Bill bill, double discount) {
        if (bill.totalAmount() > 100) {
            discount += (bill.totalAmount() / 100) * 5;
        }
        return discount;
    }

    /**
     * Apply percentage-based discounts here
     *
     * @param bill
     * @return
     */
    private double calculatePercentageBasedDiscount(Bill bill) {
        Double totalAmount = bill.totalAmount();
        double discount = 0;
        switch (bill.user().roleEnum()) {
            case EMPLOYEE -> discount = totalAmount * 0.3;
            case AFFILIATE -> discount = totalAmount * 0.1;
        }
        return discount;
    }

    /**
     * Apply years-based discount here
     *
     * @param bill
     * @return
     */
    private double calculateYearsBasedDiscount(Bill bill) {
        Double totalAmount = bill.totalAmount();
        double discount = 0;
        // Check user's customer duration and apply the discount if applicable
        if (bill.user().isCustomerOverTwoYears()) {
            discount = totalAmount * 0.05;
        }
        return discount;
    }
}
