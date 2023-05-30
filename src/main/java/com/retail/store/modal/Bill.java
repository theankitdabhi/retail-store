package com.retail.store.modal;

public record Bill(Double totalAmount,
                   boolean isGroceries,
                   User user){}