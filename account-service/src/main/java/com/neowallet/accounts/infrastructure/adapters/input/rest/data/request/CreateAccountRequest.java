package com.neowallet.accounts.infrastructure.adapters.input.rest.data.request;

import java.math.BigDecimal;

public record CreateAccountRequest(
        String ownerId,
        BigDecimal initialBalance
) {}
