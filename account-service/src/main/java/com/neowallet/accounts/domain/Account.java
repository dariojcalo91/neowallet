package com.neowallet.accounts.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class Account {
    private final UUID id;
    private final String ownerId;
    private BigDecimal balance;

    public Account(String ownerId, BigDecimal initialBalance) {
        if (initialBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
        }
        this.id = UUID.randomUUID(); // Genera un ID nuevo aquí;
        this.ownerId = ownerId;
        this.balance = initialBalance;
    }

    // Comportamiento de negocio:

    // Solo el Dominio decide cómo se suma dinero.
    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("El monto debe ser positivo");
        this.balance = this.balance.add(amount);
    }

    // Solo el Dominio decide cómo se retir dinero.
    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(this.balance) > 0) throw new IllegalStateException("Saldo insuficiente");
        this.balance = this.balance.subtract(amount);
    }

    public UUID getId() { return id; }
    public String getOwnerId() { return ownerId; }
    public BigDecimal getBalance() { return balance; }
}
