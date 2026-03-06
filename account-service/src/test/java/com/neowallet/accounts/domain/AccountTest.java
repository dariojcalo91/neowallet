package com.neowallet.accounts.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void shouldCreateAccountWithInitialBalance() {
        // Aquí fallará porque la clase Account aún no existe (Red phase de TDD)
        Account account = new Account("123", 100.0);
        assertEquals(100.0, account.getBalance());
    }

    @Test
    void shouldThrowExceptionWhenBalanceIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Account("123", -50.0);
        });
    }
}
