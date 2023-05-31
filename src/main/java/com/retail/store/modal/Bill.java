package com.retail.store.modal;

public record Bill(Double amount,
                   boolean isGroceries,
                   User user){}