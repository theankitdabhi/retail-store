package com.retail.store.service.impl;

import com.retail.store.enums.UserRoleEnum;
import com.retail.store.modal.Bill;
import com.retail.store.modal.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DiscountServiceImplTest {

    @InjectMocks
    DiscountServiceImpl discountService;

    private final User userCustomer = getCustomerUser();

    private final User userAffiliate = getAffiliateUser();

    private final User userEmployee = getEmployeeUser();

    private User getEmployeeUser() {
        return new User(true, UserRoleEnum.EMPLOYEE);
    }

    private User getCustomerUser() {
        return new User(true, UserRoleEnum.CUSTOMER);
    }

    private User getAffiliateUser() {
        return new User(true, UserRoleEnum.AFFILIATE);
    }

    @Test
    void calculateNetPayableCustomer() {
        Bill bill = new Bill(99.0, false, userCustomer);
        double expectedAmount = 94.05;

        double netPayableAmount = discountService.calculateNetPayableAmount(bill);

        assertEquals(expectedAmount, netPayableAmount);
    }

    @Test
    void calculateNetPayableAffiliate() {
        Bill bill = new Bill(500.0, false, userAffiliate);
        double expectedAmount = 425.0;

        double netPayableAmount = discountService.calculateNetPayableAmount(bill);

        assertEquals(expectedAmount, netPayableAmount);
    }

    @Test
    void calculateNetPayableEmployee() {
        Bill bill = new Bill(500.0, false, userEmployee);
        double expectedAmount = 325.0;

        double netPayableAmount = discountService.calculateNetPayableAmount(bill);

        assertEquals(expectedAmount, netPayableAmount);
    }

    @Test
    void calculateNetPayableAmountWithGroceriesForCustomer() {
        Bill bill = new Bill(500.0, true, userCustomer);
        double expectedAmount = 475.0;

        double netPayableAmount = discountService.calculateNetPayableAmount(bill);

        assertEquals(expectedAmount, netPayableAmount);
    }

    @Test
    void calculateNetPayableAmountWithoutGroceriesForCustomer() {
        Bill bill = new Bill(500.0, false, userCustomer);
        double expectedAmount = 450.0;

        double netPayableAmount = discountService.calculateNetPayableAmount(bill);

        assertEquals(expectedAmount, netPayableAmount);
    }
}