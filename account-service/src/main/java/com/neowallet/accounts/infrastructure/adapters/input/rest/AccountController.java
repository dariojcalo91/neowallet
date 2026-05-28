package com.neowallet.accounts.infrastructure.adapters.input.rest;

import com.neowallet.accounts.application.services.CreateAccountService;
import com.neowallet.accounts.domain.Account;
import com.neowallet.accounts.infrastructure.adapters.input.rest.data.request.CreateAccountRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final CreateAccountService createAccountService;

    @PostMapping
    public ResponseEntity<UUID> createAccount(@RequestBody CreateAccountRequest request) {
        Account account = createAccountService.execute(
                request.ownerId(),
                request.initialBalance()
        );
        return new ResponseEntity<>(account.getId(), HttpStatus.CREATED);
    }
}