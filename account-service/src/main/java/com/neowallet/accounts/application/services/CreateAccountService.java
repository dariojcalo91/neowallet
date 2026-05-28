package com.neowallet.accounts.application.services;

import com.neowallet.accounts.application.ports.output.AccountRepository;
import com.neowallet.accounts.domain.Account;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor // Genera el constructor para la inyección de dependencias
public class CreateAccountService {

    private final AccountRepository accountRepository;

    public Account execute(String ownerId, BigDecimal initialBalance) {
        // 1. Regla de negocio: No se puede crear cuenta si el balance es menor a 10 (ejemplo)
        if (initialBalance.compareTo(BigDecimal.valueOf(10.0)) < 0) {
            throw new IllegalArgumentException("El depósito inicial mínimo es 10.0");
        }

        // 2. Creamos la entidad de dominio
        Account account = new Account(ownerId, initialBalance);

        // 3. Guardamos a través del puerto (sin saber qué DB hay detrás)
        return accountRepository.save(account);
    }
}
