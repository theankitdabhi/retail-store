package com.retail.store.modal;

import com.retail.store.enums.UserRoleEnum;

public record User(boolean isCustomerOverTwoYears, UserRoleEnum roleEnum) {
}
